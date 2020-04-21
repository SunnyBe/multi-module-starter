package com.zistus.feature_authentication.di

import android.app.Application
import com.zistus.core.MyApplication
import com.zistus.core.di.BaseFeatureInjector
import dagger.Module
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

@Module
class AuthFeatureInjector: BaseFeatureInjector {
    @Inject // Make an android injector
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun inject(app: Application) {
        DaggerAuthFeatureComponent.builder()
            .coreComponent((app as MyApplication).coreComponent)
            .build()
            .inject(this)
    }
    override fun androidInjector(): DispatchingAndroidInjector<Any> = androidInjector
}