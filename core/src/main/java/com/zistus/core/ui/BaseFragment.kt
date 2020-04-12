package com.zistus.core.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zistus.core.ui.viewModel.BaseViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : DaggerFragment() {
    @get:LayoutRes
    protected abstract val layoutResourceId: Int
    abstract val viewModel: VM  // Specify the viewModel for this fragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@BaseFragment, Observer {
        block(it)
    })
}