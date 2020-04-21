package com.zistus.core.ui.viewModel

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.play.core.splitinstall.SplitInstallException
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.google.android.play.core.tasks.Task
import com.zistus.core.util.misc.*
import kotlinx.coroutines.launch
import timber.log.Timber
/**
 * Basic functionality that all modules can perform. For example navigation through screens
 */
abstract class BaseViewModel : ViewModel() {
    // Navigation Live data
    private val _intentNavigation = MutableLiveData<Intent>()
    val intentNavigation: LiveData<Intent> get() = _intentNavigation

    // Error Live data
    private val _errorState = MutableLiveData<Throwable>()
    val errorState: LiveData<Throwable> get() = _errorState

    // Progress
    private val _setProgress = MutableLiveData<String?>()
    val setProgress: LiveData<String?> get() = _setProgress

    val progressState = MutableLiveData<Long>()

    private var sessionId = 0
    private var screenPath: String = ""
    private var entry: String = ""

    fun renderError(error: ErrorManager) {
        _errorState.value = error
    }

    fun navigate(intent: Intent) {
        _intentNavigation.value = intent
    }

    // Navigate to the next activity via Intent using url
    fun navigate(url: String) {
        _intentNavigation.value = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }

    // Append screen path and Navigate using deep-link
    fun navigateScreen(screenPath: String) {
        navigate("${Urls.AppScheme}$screenPath")
    }

    fun showProgress(message: String) {
        _setProgress.postValue(message)
    }

    fun removeProgress() {
        _setProgress.postValue(null)
    }

    fun includeModule(
        splitInstallUtil: SplitInstallUtil,
        moduleName: String,
        screenPath: String,
        entry: String
    ) {
        this.screenPath = screenPath
        this.entry = entry
        viewModelScope.launch {
            val task = splitInstallUtil.includeModule(moduleName, splitStateListener)
            proceesTask(splitInstallUtil, task)
        }
    }

    private fun proceesTask(
        splitInstallUtil: SplitInstallUtil,
        task: Task<Int>
    ) {
        task.addOnSuccessListener {
            // show progress and set sessionId
            showProgress("Downloading")
            sessionId = it
        }

        task.addOnFailureListener {
            // dismiss and display error
            splitInstallException(splitInstallUtil, it)
        }

        task.addOnCompleteListener {
            splitInstallUtil.unregisterSplitListener(splitStateListener)
        }
    }

    private fun splitInstallException(splitInstallUtil: SplitInstallUtil, exception: Exception?) {
        when ((exception as SplitInstallException).errorCode) {
            SplitInstallErrorCode.NETWORK_ERROR -> {
                removeProgress()
                // Display a message that requests the user to establish a
                // network connection.
                renderError(
                    ErrorManager(
                        ErrorType.CORE_SPLIT,
                        "Something wrong with your internet",
                        exception
                    )
                )
            }
            SplitInstallErrorCode.ACTIVE_SESSIONS_LIMIT_EXCEEDED -> {
                activeSessionLimitExceeded(splitInstallUtil)
            }

            SplitInstallErrorCode.API_NOT_AVAILABLE -> {
                renderError(
                    exception.toErrorManager(
                        ErrorType.CORE_SPLIT,
                        "API is not available, contact developer"
                    )
                )
            }

            else -> {
                renderError(exception.toErrorManager(ErrorType.CORE_SPLIT))
            }
        }
    }

    private fun activeSessionLimitExceeded(splitInstallUtil: SplitInstallUtil) {
        viewModelScope.launch {
            splitInstallUtil.checkForActiveDownloads(sessionId)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Check for active sessions.
                        for (state in task.result) {
                            if (state.status() == SplitInstallSessionStatus.DOWNLOADING) {
                                // Cancel the request, or request a deferred installation.
                                splitInstallUtil.splitInstallManager.cancelInstall(sessionId)
                                renderError(task.exception.toErrorManager(ErrorType.CORE_SPLIT))
                            }
                        }
                    }
                }
        }
    }

    // Creates a listener for request status updates.
    private val splitStateListener = SplitInstallStateUpdatedListener { state ->
        if (state.sessionId() == sessionId) {
            // Read the status of the request to handle the state update.
            splitStatusStateUpdate(state)
        }
    }

    private fun splitStatusStateUpdate(state: SplitInstallSessionState?) {
        when (state?.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> {
                val totalBytes = state.totalBytesToDownload()
                val progress = state.bytesDownloaded()
                // Update progress bar.
                progressState.postValue(progress)
            }
            SplitInstallSessionStatus.INSTALLED -> {
                removeProgress()
                if (screenPath.isNotBlank()) navigateScreen("$screenPath/${entry}")
            }
            SplitInstallSessionStatus.PENDING -> {
                showProgress("Loading Module")
            }

            else -> {
                Timber.d("${state?.status()} was not accounted for")
            }
        }
    }
}