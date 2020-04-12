package com.zistus.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zistus.core.ui.viewModel.BaseViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragmentNav<FragmentBinding: ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {
    @get:LayoutRes
    protected abstract val layoutResourceId: Int
    abstract val viewModel: VM  // Specify the viewModel for this fragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    lateinit var fragmentBinding: FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = DataBindingUtil.inflate(layoutInflater, layoutResourceId, container, false)
        return fragmentBinding.root
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