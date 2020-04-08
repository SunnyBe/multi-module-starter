package com.zistus.multimodule.ui.launcher

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class LauncherActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): LauncherActivity

    @Module
    class LauncherModule {
        @Provides
        fun provideTestSting(): String = "This is a test string for launcher"
    }
}