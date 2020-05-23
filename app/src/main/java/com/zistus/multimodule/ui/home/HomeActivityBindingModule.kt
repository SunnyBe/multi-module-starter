package com.zistus.multimodule.ui.home

import androidx.lifecycle.ViewModel
import com.zistus.core.di.module.ViewModelModule
import com.zistus.core.util.annotation.dagger.FeatureScope
import com.zistus.core.util.annotation.dagger.ViewModelKey
import com.zistus.multimodule.ui.newdoc.NewDocFragment
import com.zistus.multimodule.ui.newdoc.NewDocViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeActivityBindingModule {

    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class, HomeModule::class, ViewModelModule::class])
    abstract fun contributeHomeActivity(): HomeActivity


    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class, HomeModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class, HomeModule::class])
    abstract fun contributeSubHomeFragment(): SubHomeFragment

    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class, HomeModule::class])
    abstract fun contributeNewDocFragment(): NewDocFragment

    @Module
    abstract class HomeViewModelBindingModule {
        @Binds
        @IntoMap
        @ViewModelKey(HomeViewModel::class)
        abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(NewDocViewModel::class)
        abstract fun bindNewDocViewModel(viewModel: NewDocViewModel): ViewModel

    }

    @Module
    class HomeModule {
        @Provides
        fun provideTestSting(): String = "This is a test string for home"
    }
}