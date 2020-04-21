package com.zistus.feature_authentication.di

import com.zistus.core.util.annotation.dagger.FeatureScope
import com.zistus.feature_authentication.ui.logout.LoginDataSource
import com.zistus.feature_authentication.ui.logout.LoginRepository
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {
    @FeatureScope
    @Provides
    fun provideLoginDataSource() = LoginDataSource()

    @FeatureScope
    @Provides
    fun provideLoginRepository(dataSource: LoginDataSource) = LoginRepository(dataSource)
}