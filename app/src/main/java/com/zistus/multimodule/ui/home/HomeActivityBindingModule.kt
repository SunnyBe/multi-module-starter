package com.zistus.multimodule.ui.home

import androidx.lifecycle.ViewModel
import com.zistus.core.util.annotation.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeActivityBindingModule {

    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class, HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity


    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class, HomeModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @Module
    abstract class HomeViewModelBindingModule {
        @Binds
        @IntoMap
        @ViewModelKey(HomeViewModel::class)
        abstract fun bindLauncherViewModel(homeViewModel: HomeViewModel): ViewModel
    }

    @Module
    class HomeModule {
        @Provides
        fun provideTestSting(): String = "This is a test string for home"
    }
}