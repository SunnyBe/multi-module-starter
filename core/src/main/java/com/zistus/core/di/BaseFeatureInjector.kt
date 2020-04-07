package com.zistus.core.di

import android.app.Application
import dagger.android.DispatchingAndroidInjector

interface BaseFeatureInjector {
    fun inject(app: Application)    // Extends injection into application to the extending class

    fun androidInjector(): DispatchingAndroidInjector<Any>
}