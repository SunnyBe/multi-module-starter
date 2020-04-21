package com.zistus.feature_authentication.di

import com.zistus.core.di.CoreComponent
import com.zistus.core.di.module.ViewModelModule
import com.zistus.core.util.annotation.dagger.FeatureScope
import com.zistus.feature_authentication.ui.login.AuthenticationActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        AndroidInjectionModule::class,
        AuthenticationActivityBindingModule::class,
        FeatureModule::class,
        ViewModelModule::class
    ]
)
interface AuthFeatureComponent {
    /**
     * Make the AppFeatureComponent graph available to AppFeatureInjector
     */
    fun inject(appFeatureInjector: AuthFeatureInjector)
}