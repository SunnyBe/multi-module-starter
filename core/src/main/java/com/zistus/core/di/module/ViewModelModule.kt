package com.zistus.core.di.module

import androidx.lifecycle.ViewModelProvider
import com.zistus.core.util.annotation.dagger.FeatureScope
import com.zistus.core.util.misc.DaggerViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}