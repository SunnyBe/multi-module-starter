package com.zistus.core.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.zistus.core.MyApplication
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.ui.viewModel.BaseViewModel
import com.zistus.core.util.misc.PermissionHelper
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseNavActivity<VM: BaseViewModel>: DaggerAppCompatActivity() {

    abstract val featureInjector: BaseFeatureInjector

    abstract val layoutResId: Int   // Specify the layout id for the extending class

    abstract val viewModel: VM  // Specify the viewModel for this activity

    abstract fun getNavControllerId(): Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    private val navController: NavController by lazy {
        findNavController(getNavControllerId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).addModuleInjector(featureInjector)   // Add this
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        viewModel.intentNavigation.observe {
            Timber.d("Navigate ${it.data}")
            startActivity(it)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@BaseNavActivity, Observer {
        block(it)
    })
}