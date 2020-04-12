package com.zistus.multimodule.domain.test

import com.zistus.core.entity.DataState

interface TestRepository {
    suspend fun fetchUsers(): DataState<List<TestEntity.User>>
}