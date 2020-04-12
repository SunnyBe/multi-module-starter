package com.zistus.multimodule.data.api

import com.zistus.multimodule.data.api.test.TestDto
import retrofit2.http.GET

interface AppApiService {
    @GET("users")
    suspend fun users(): List<TestDto.UsersResponse>
}