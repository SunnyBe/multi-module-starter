package com.zistus.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zistus.core.ui.viewModel.BaseViewModel
import com.zistus.core.util.misc.ErrorManager
import com.zistus.core.util.misc.ErrorType
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.layout_progress_infinite.view.*
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragmentNav<VM : BaseViewModel> : DaggerFragment() {
    @get:LayoutRes
    protected abstract val layoutResourceId: Int
    abstract val viewModel: VM  // Specify the viewModel for this fragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(this.layoutResourceId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.progressBarInfinite
        viewModel.intentNavigation.observe {
            Timber.e("Should start intent ${it.type}")
            activity?.startActivity(it)
        }
        viewModel.setProgress.observe { msg->
            msg?.let { showProgress(it) }?: kotlin.run { hideProgress() }
        }

        viewModel.progressState.observe {
            progressBar.isIndeterminate = false
            progressBar.progress = it.toInt()
        }
    }

    // Show progress bar to user
    fun showProgress(msg: String) {
        if (::progressBar.isInitialized) {
            progressBar.contentDescription = msg
            progressBar.visibility = View.VISIBLE
        }
    }

    // Hide already displaying progress bar
    fun hideProgress() {
        if (::progressBar.isInitialized && progressBar.isVisible) progressBar.visibility = View.GONE
    }

    // Show error
    fun showError(type: ErrorType, error: Throwable) {
        viewModel.renderError(error = ErrorManager(type, error.message, error))
    }

    fun navigateFragment(@IdRes destination: Int) {
        findNavController().navigate(destination)
    }

    fun navigateFragment(@IdRes destination: Int, bundle: Bundle) {
        findNavController().navigate(destination, bundle)
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(viewLifecycleOwner, Observer {
        block(it)
    })
}