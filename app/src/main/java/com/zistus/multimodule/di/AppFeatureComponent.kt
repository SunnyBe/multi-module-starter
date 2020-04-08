package com.zistus.multimodule.di

import com.zistus.core.di.CoreComponent
import com.zistus.core.util.annotation.dagger.FeatureScope
import com.zistus.multimodule.ui.home.HomeActivityBindingModule
import com.zistus.multimodule.ui.home.HomeModule
import com.zistus.multimodule.ui.launcher.LauncherActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        AndroidInjectionModule::class,
        HomeActivityBindingModule::class,
        LauncherActivityBindingModule::class,
        HomeModule::class
    ]
)
interface AppFeatureComponent {
    /**
     * Make the AppFeatureComponent graph available to AppFeatureInjector
     */
    fun inject(appFeatureInjector: AppFeatureInjector)
}