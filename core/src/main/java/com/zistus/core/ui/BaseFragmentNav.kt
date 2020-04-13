package com.zistus.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zistus.core.ui.viewModel.BaseViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.layout_progress_infinite.view.*
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragmentNav<FragmentBinding: ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {
    @get:LayoutRes
    protected abstract val layoutResourceId: Int
    abstract val viewModel: VM  // Specify the viewModel for this fragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    lateinit var fragmentBinding: FragmentBinding

    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = DataBindingUtil.inflate(layoutInflater, layoutResourceId, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = fragmentBinding.root.progressBarInfinite
        viewModel.intentNavigation.observe {
            Timber.e("Should start intent ${it.type}")
            activity?.startActivity(it)
        }
    }

    // Show progress bar to user
    fun showProgress() {
        if (::progressBar.isInitialized) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
    }

    // Hide already displaying progress bar
    fun hideProgress() {
        if (::progressBar.isInitialized && progressBar.isVisible) progressBar.visibility = View.GONE
    }

    fun navigateFragment(@IdRes destination: Int) {
        findNavController().navigate(destination)
    }

    fun navigateFragment(@IdRes destination: Int, bundle: Bundle) {
        findNavController().navigate(destination, bundle)
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@BaseFragmentNav, Observer {
        block(it)
    })
}