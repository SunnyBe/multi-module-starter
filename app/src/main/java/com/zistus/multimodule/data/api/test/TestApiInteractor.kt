package com.zistus.multimodule.data.api.test

interface TestApiInteractor {
    suspend fun users(): List<TestDto.UsersResponse>
}