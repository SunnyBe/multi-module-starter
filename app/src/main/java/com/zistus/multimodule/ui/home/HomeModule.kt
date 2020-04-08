package com.zistus.multimodule.ui.home

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeModule {

    @Provides
    fun provideTestSting(): String = "This is a test string for home"
}