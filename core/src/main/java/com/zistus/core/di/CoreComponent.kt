package com.zistus.core.di

import android.content.Context
import com.zistus.core.MyApplication
import com.zistus.core.di.module.CoreModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, CoreModule::class])   // Include the modules and dependencies
interface CoreComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: MyApplication): CoreComponent    // Make core component graph available to application
    }

    fun provideApplicationContext(): Context    // Make context available to the core component graph
}