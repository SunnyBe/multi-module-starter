package com.zistus.core.di.module

import com.zistus.core.ui.BaseFragment
import dagger.Binds
import dagger.Module

@Module
abstract class FragmentModule {
    @Binds
    abstract fun bindBaseFragement(): BaseFragment
}