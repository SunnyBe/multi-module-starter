package com.zistus.multimodule.di

import com.zistus.multimodule.BuildConfig
import com.zistus.multimodule.data.api.AppApiService
import com.zistus.multimodule.data.api.test.TestApiImplementation
import com.zistus.multimodule.data.api.test.TestApiInteractor
import com.zistus.multimodule.data.db.test.TestDbInteractor
import com.zistus.multimodule.data.repository.test.TestRepositoryImplementation
import com.zistus.multimodule.domain.test.TestRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideAppRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Singleton
    @Provides
    fun provideOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient {
        val client = okHttpClientBuilder
            .readTimeout(60000, TimeUnit.MICROSECONDS)
        return client.build()
    }

    @Singleton
    @Provides
    fun provideAppApiClient(retrofit: Retrofit): AppApiService =
        retrofit.create(AppApiService::class.java)

    @Singleton
    @Provides
    fun provideTestApiInteractor(apiService: AppApiService): TestApiInteractor =
        TestApiImplementation(apiService)

    @Singleton
    @Provides
    fun provideTestRepository(
        testApiInteractor: TestApiInteractor,
        testDbInteractor: TestDbInteractor
    ): TestRepository = TestRepositoryImplementation(testApiInteractor, testDbInteractor)
}