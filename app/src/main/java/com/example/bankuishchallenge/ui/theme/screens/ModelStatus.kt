package com.example.bankuishchallenge.ui.theme.screens

enum class Status {
    NETWORK_ERROR,
    ERROR,
    SUCCESS,

    INTERNET_CONNECTION_ERROR,
}

data class ModelStatus(
    val status: Status,
    val message: String? = null
)

data class ErrorStatus(
    val showError: Boolean = false,
    val showGenericError: Boolean = false,
)
