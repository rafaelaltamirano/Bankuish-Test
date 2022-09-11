package com.example.bankuishchallenge.ui.theme.screens.repos

import com.example.domain.entities.Repo

data class ReposState(
    val repos: List<Repo> = emptyList(),
    val loadingRepos : Boolean = false,
    val selectedRepo : Repo? = null,
    )