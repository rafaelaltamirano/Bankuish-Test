package com.example.bankuishchallenge.di

import com.example.bankuishchallenge.api.ReposApi
import com.example.bankuishchallenge.api.schemas.response.repos.ReposResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    fun getReposApi(baseUrl: String, client: OkHttpClient? = null): ReposApi {
        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
        client?.also(builder::client)
        return builder.build().create(ReposApi::class.java)
    }
}