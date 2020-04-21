package com.zistus.multimodule.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zistus.core.data.BaseDatabase
import com.zistus.multimodule.data.db.test.dao.TestDao
import com.zistus.multimodule.data.db.test.entity.TestData

@Database(entities = [TestData.User::class, TestData.Post::class], version = 1, exportSchema = false)
abstract class MyDatabase: BaseDatabase() {
    abstract fun userDao(): TestDao.UserDao
    abstract fun postDao(): TestDao.PostDao
}