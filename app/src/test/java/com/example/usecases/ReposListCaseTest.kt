package com.example.usecases

import com.example.data.dao.ReposDao
import com.example.domain.entities.Author
import com.example.domain.entities.Repo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*


@ExperimentalCoroutinesApi
class ReposListCaseTest {


    private lateinit var reposDao: ReposDao
    private lateinit var reposListCase: ReposListCase
    private val author =
        Author(
            login = "login",
            type = "type"
        )


    val repos = listOf(
        Repo(
            name = "nombre",
            author = author,
            fullName = " full name",
            url = "url"

        )
    )

    @BeforeEach
    fun setUp() {
        reposDao = mock()
        reposListCase = ReposListCase(reposDao)
    }

    @Test
    fun requestRepos_request_returnSuccess() = runTest {

        reposDao.stub {
            onBlocking { fetchRepos() }.doReturn(repos)
        }
        val res = reposListCase.requestRepos()
        assertEquals(1, res.size)

    }
}
