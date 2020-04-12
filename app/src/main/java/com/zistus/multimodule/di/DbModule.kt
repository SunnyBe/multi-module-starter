package com.zistus.multimodule.di

import android.content.Context
import androidx.room.Room
import com.zistus.multimodule.data.api.test.TestDto
import com.zistus.multimodule.data.db.MyDatabase
import com.zistus.multimodule.data.db.test.TestDbImplementation
import com.zistus.multimodule.data.db.test.TestDbInteractor
import com.zistus.multimodule.data.db.test.dao.TestDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideMyDatabase(context: Context) = Room.databaseBuilder(context, MyDatabase::class.java, "mydatabase")
        .build()

    @Singleton
    @Provides
    fun provideUserDao(myDatabase: MyDatabase) = myDatabase.userDao()

    @Singleton
    @Provides
    fun providePostDao(myDatabase: MyDatabase) = myDatabase.userDao()

    @Singleton
    @Provides
    fun provideTestDbInteractor(userDao: TestDao.UserDao): TestDbInteractor = TestDbImplementation(userDao)

}