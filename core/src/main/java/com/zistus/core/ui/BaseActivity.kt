package com.zistus.core.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zistus.core.MyApplication
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.viewModel.BaseViewModel
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel>: DaggerAppCompatActivity() {

    abstract val featureInjector: BaseFeatureInjector

    abstract val viewModel: VM  // Specify the viewModel for this activity

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).addModuleInjector(featureInjector)   // Add this
        super.onCreate(savedInstanceState)
        viewModel.intentNavigation.observe {
            Timber.d("Navigate ${it.data}")
            startActivity(it)
        }
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@BaseActivity, Observer {
        block(it)
    })
}