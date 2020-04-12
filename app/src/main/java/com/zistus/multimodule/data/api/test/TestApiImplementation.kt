package com.zistus.multimodule.data.api.test

import com.zistus.multimodule.data.api.AppApiService

class TestApiImplementation(private val apiService: AppApiService): TestApiInteractor {
    override suspend fun users(): List<TestDto.UsersResponse> {
        return apiService.users()
    }
}