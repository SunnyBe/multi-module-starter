package com.zistus.core

import com.zistus.core.di.CoreComponent
import com.zistus.core.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class MyApplication : DaggerApplication() {
    // Create core component instance from core component interface factory from CoreComponent
    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val moduleAndroidInjectors = mutableListOf<DispatchingAndroidInjector<Any>>()

    val androidInjector = AndroidInjector<Any>(::processAndroidInjector)

    private fun processAndroidInjector(instance: Any) {
        if (dispatchingAndroidInjector.maybeInject(instance)) {
            return
        }
        moduleAndroidInjectors.forEach{ injector->
            if (injector.maybeInject(instance)) return
        }

        throw IllegalStateException("$instance Injector not found.")
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = coreComponent
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    // Set up all applications
    override fun onCreate() {
        super.onCreate()
    }
}