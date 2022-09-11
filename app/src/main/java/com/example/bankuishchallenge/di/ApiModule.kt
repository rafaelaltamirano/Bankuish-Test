package com.example.bankuishchallenge.di


import android.content.Context
import com.example.bankuishchallenge.api.ReposApi
import com.example.bankuishchallenge.di.ApiProvider.getReposApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor {
                val builder = it.request().newBuilder()
                it.proceed(builder.build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun providerReposApi(
        client: OkHttpClient
    ): ReposApi {
        val baseURL = "https://api.github.com/"
        return getReposApi(baseURL, client)
    }
}