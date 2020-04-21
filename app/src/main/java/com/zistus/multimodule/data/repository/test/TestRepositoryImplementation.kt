package com.zistus.multimodule.data.repository.test

import com.zistus.core.entity.DataState
import com.zistus.multimodule.data.api.test.TestApiInteractor
import com.zistus.multimodule.data.db.test.TestDbInteractor
import com.zistus.multimodule.domain.test.TestEntity
import com.zistus.multimodule.domain.test.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TestRepositoryImplementation(
    private val apiSource: TestApiInteractor,
    private val dbSource: TestDbInteractor
) :
    TestRepository {
    override suspend fun fetchUsers(): DataState<List<TestEntity.User>>  = withContext(Dispatchers.IO) {
        try {
            DataState.Success(apiSource.users().map { it.toEntity() }) as DataState<List<TestEntity.User>>
        } catch (ex: Throwable) {
            DataState.Error(ex, null) as DataState<List<TestEntity.User>>
        }
    }
}