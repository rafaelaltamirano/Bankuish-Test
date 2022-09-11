package com.example.bankuishchallenge.api

import com.example.bankuishchallenge.api.schemas.response.ResponseWrapper
import com.example.bankuishchallenge.api.schemas.response.repos.ReposResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ReposApi {

    @GET("search/repositories")
    @Headers("Content-Type: application/json; charset=UTF-8")
    suspend fun requestRepos(
        @Query("q") q: String,
        @Query("per_page")pePage: Int,
        @Query("page") page: Int,
    ): Response<ResponseWrapper<List<ReposResponse>>>
}