package com.example.data.dao

import com.example.domain.entities.Repo

interface ReposDao {
    suspend fun fetchRepos(
    ): List<Repo>
}