package com.example.bankuishchallenge.api.schemas.response

interface Response<T> {

    fun toEntity(): T

}