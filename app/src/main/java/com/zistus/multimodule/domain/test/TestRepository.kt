package com.zistus.multimodule.domain.test

interface TestRepository {
    suspend fun fetchUsers(): List<TestEntity.User>
}