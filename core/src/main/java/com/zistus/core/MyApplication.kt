package com.zistus.core

import com.google.android.play.core.splitcompat.SplitCompat
import com.zistus.core.di.BaseFeatureInjector
import com.zistus.core.di.CoreComponent
import com.zistus.core.di.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

open class MyApplication : DaggerApplication() {
    // Create core component instance from core component interface factory from CoreComponent
    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    // List of injected modules extending the base feature Injector
    private val injectedModules = mutableSetOf<BaseFeatureInjector>()

    private val moduleAndroidInjectors = mutableListOf<DispatchingAndroidInjector<Any>>()

    private val androidInjector = AndroidInjector<Any>(::processAndroidInjector)

    // Android injector callback when an injector instance is available
    private fun processAndroidInjector(instance: Any) {
        // Check if specified instance of injector is part of the the module android injectors
        if (dispatchingAndroidInjector.maybeInject(instance)) return
        moduleAndroidInjectors.forEach{ injector->
            if (injector.maybeInject(instance)) return
        }

        throw IllegalStateException("$instance Injector not found.")
    }

    // Add the specified feature injector to the list of injectors
    fun addModuleInjector(featureInjector: BaseFeatureInjector) {
        if (injectedModules.contains(featureInjector)) return
        featureInjector.inject(this)
        moduleAndroidInjectors.add(featureInjector.androidInjector())
        injectedModules.add(featureInjector)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = coreComponent
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    // Set up all applications
    override fun onCreate() {
        super.onCreate()
        SplitCompat.install(this)
        coreComponent.inject(this)
    }

//    override fun attachBaseContext(base: Context?) {
//        super.attachBaseContext(base)
//        SplitCompat.install(this)
//    }
}