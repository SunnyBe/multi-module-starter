package com.zistus.multimodule.data.db.test.dao

import androidx.room.Dao
import com.zistus.core.data.BaseDao
import com.zistus.multimodule.data.db.test.entity.TestData

sealed class TestDao {
    @Dao
    abstract class UserDao: BaseDao<TestData.User>{
    }
    @Dao
    abstract class PostDao: BaseDao<TestData.Post> {
    }
}