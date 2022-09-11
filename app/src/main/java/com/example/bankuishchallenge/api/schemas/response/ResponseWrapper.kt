package com.example.bankuishchallenge.api.schemas.response


data class ResponseWrapper<T>(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: T
)


