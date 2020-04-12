package com.zistus.multimodule.data.db.test

import com.zistus.multimodule.data.api.test.TestDto
import com.zistus.multimodule.domain.test.TestEntity

interface TestDbInteractor {
    suspend fun saveUsers(users: List<TestEntity.User>): Unit
}