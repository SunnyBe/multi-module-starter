package com.zistus.multimodule.ui.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity
}