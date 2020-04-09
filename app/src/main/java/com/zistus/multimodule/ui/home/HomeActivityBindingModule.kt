package com.zistus.multimodule.ui.home

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityBindingModule {

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @Module
    class HomeModule {
        @Provides
        fun provideTestSting(): String = "This is a test string for home"
    }
}