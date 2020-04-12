package com.zistus.multimodule.data.db.test

import com.zistus.multimodule.data.db.test.dao.TestDao
import com.zistus.multimodule.domain.test.TestEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TestDbImplementation(private val userDao: TestDao.UserDao): TestDbInteractor {
    override suspend fun saveUsers(users: List<TestEntity.User>): Unit = withContext(Dispatchers.IO) {
        userDao.insert(users.map { it.toData() })
    }
}