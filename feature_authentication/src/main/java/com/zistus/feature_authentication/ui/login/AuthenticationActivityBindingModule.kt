package com.zistus.feature_authentication.ui.login

import androidx.lifecycle.ViewModel
import com.zistus.core.util.annotation.dagger.ViewModelKey
import com.zistus.feature_authentication.ui.AuthenticationActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class AuthenticationActivityBindingModule {

    @ContributesAndroidInjector(modules = [AuthenticationViewModelBindingModule::class, AuthModule::class])
    abstract fun contributeAuthenticationActivity(): AuthenticationActivity


    @ContributesAndroidInjector(modules = [AuthenticationViewModelBindingModule::class, AuthModule::class])
    abstract fun contributeAuthFragment(): AuthenticationFragment

    @Module
    abstract class AuthenticationViewModelBindingModule {
        @Binds
        @IntoMap
        @ViewModelKey(AuthenticationViewModel::class)
        abstract fun bindAuthenticationViewModel(authenticationViewModel: AuthenticationViewModel): ViewModel

    }

    @Module
    class AuthModule {
        @Provides
        fun provideTestSting(): String = "This is a test string for auth"
    }
}