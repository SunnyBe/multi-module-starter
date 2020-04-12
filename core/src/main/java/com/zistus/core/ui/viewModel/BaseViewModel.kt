package com.zistus.core.ui.viewModel

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zistus.core.util.misc.ErrorManager
import com.zistus.core.util.misc.Urls

/**
 * Basic functionality that all modules can perform. For example navigation through screens
 */
abstract class BaseViewModel: ViewModel() {
    // Navigation Live data
    private val _intentNavigation = MutableLiveData<Intent>()
    val intentNavigation: LiveData<Intent> get() = _intentNavigation
    // Loading Live data
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState
    // Error Live data
    private val _errorState = MutableLiveData<Throwable>()
    val errorState: LiveData<Throwable> get() = _errorState

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
}