package com.example.bankuishchallenge.framework.datasource

import com.example.bankuishchallenge.api.ReposApi
import com.example.data.dao.ReposDao
import com.example.domain.entities.Repo
import javax.inject.Inject


class ReposDaoImp @Inject constructor(
    private val api: ReposApi
): ReposDao {

    override suspend fun fetchRepos(): List<Repo> {
        val res = api.requestRepos(
            page = 1,
            pePage = 20,
            q = "kotlin"
        )

        return  res.body()!!.items.map { it.toEntity() }
    }

}