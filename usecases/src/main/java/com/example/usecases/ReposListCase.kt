package com.example.usecases

import com.example.data.dao.ReposDao
import com.example.domain.entities.Repo

class ReposListCase(
    private val reposDao: ReposDao
) {
    suspend fun requestRepos(): List<Repo> {
        return try {
            reposDao.fetchRepos()
        } catch (e: Exception) {
            throw e
        }
    }
}