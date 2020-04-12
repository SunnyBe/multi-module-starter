package com.zistus.core.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zistus.core.MyApplication
import com.zistus.core.di.BaseFeatureInjector
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity<Binding: ViewDataBinding, VM: BaseViewModel>: DaggerAppCompatActivity() {

    abstract val featureInjector: BaseFeatureInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract val layoutResId: Int   // Specify the layout id for the extending class

    abstract val viewModel: VM  // Specify the viewModel for this activity

    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    val binding: Binding by lazy { DataBindingUtil.setContentView<Binding>(this, layoutResId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).addModuleInjector(featureInjector)   // Add this
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        binding.lifecycleOwner = this
        viewModel.intentNavigation.observe {
            Timber.d("Navigate ${it.data}")
            startActivity(it)
        }
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@BaseActivity, Observer {
        block(it)
    })
}