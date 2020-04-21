package com.zistus.multimodule.di.module

import android.content.Context
import androidx.room.Room
import com.zistus.core.util.annotation.dagger.FeatureScope
import com.zistus.multimodule.data.db.MyDatabase
import com.zistus.multimodule.data.db.test.TestDbImplementation
import com.zistus.multimodule.data.db.test.TestDbInteractor
import com.zistus.multimodule.data.db.test.dao.TestDao
import dagger.Module
import dagger.Provides

@Module
class DbModule {
    @FeatureScope
    @Provides
    fun provideMyDatabase(context: Context) = Room.databaseBuilder(context, MyDatabase::class.java, "mydatabase")
        .build()

    @FeatureScope
    @Provides
    fun provideUserDao(myDatabase: MyDatabase) = myDatabase.userDao()

    @FeatureScope
    @Provides
    fun providePostDao(myDatabase: MyDatabase) = myDatabase.postDao()

    @FeatureScope
    @Provides
    fun provideTestDbInteractor(userDao: TestDao.UserDao): TestDbInteractor = TestDbImplementation(userDao)

}