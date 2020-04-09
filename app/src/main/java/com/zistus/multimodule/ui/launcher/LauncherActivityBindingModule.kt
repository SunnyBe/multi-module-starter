package com.zistus.multimodule.ui.launcher

import androidx.lifecycle.ViewModel
import com.zistus.core.util.annotation.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LauncherActivityBindingModule {

    @ContributesAndroidInjector(modules = [LauncherViewModelBindingModule::class, LauncherModule::class])
    abstract fun contributeLauncherActivity(): LauncherActivity

    @Module
    abstract class LauncherViewModelBindingModule {
        @Binds
        @IntoMap
        @ViewModelKey(LauncherViewModel::class)
        abstract fun bindLauncherViewModel(launcherViewModel: LauncherViewModel): ViewModel

    }

    @Module
    class LauncherModule {
        @Provides
        fun provideTestSting(): String = "This is a test string for launcher"
    }
}