package com.zistus.multimodule.di

import com.zistus.core.util.annotation.dagger.FeatureScope
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
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @FeatureScope
    @Provides
    fun provideAppRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @FeatureScope
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @FeatureScope
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @FeatureScope
    @Provides
    fun providesOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder,
                             httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }

    @FeatureScope
    @Provides
    fun provideAppApiClient(retrofit: Retrofit): AppApiService =
        retrofit.create(AppApiService::class.java)

    @FeatureScope
    @Provides
    fun provideTestApiInteractor(apiService: AppApiService): TestApiInteractor =
        TestApiImplementation(apiService)

    @FeatureScope
    @Provides
    fun provideTestRepository(
        testApiInteractor: TestApiInteractor,
        testDbInteractor: TestDbInteractor
    ): TestRepository = TestRepositoryImplementation(testApiInteractor, testDbInteractor)
}