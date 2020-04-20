package com.zistus.multimodule.domain.test

import com.zistus.core.domain.BaseRepository
import com.zistus.core.entity.DataState

interface TestRepository: BaseRepository {
    suspend fun fetchUsers(): DataState<List<TestEntity.User>>
}