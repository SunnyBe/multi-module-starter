package com.zistus.core.di.module

import android.content.Context
import com.zistus.core.MyApplication
import com.zistus.core.util.misc.SplitInstallUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    // Make application context available to the graph
    @Provides
    @Singleton
    fun provideApplicationContext(app: MyApplication): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSplitInstall(context: Context) = SplitInstallUtil(context)
}