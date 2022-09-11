package com.example.bankuishchallenge.ui.theme.screens.repos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.bankuishchallenge.ui.theme.screens.Status
import com.example.bankuishchallenge.ui.theme.screens.ViewModelWithStatus
import com.example.domain.entities.Repo
import com.example.usecases.ReposListCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ReposListModel @Inject constructor(
    private val reposListCase: ReposListCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(ReposState())
        private set

    init {
        setLoadingRepos(true)
        requestRepos()
    }

    private fun setRepos(repos: List<Repo>){
        state = state.copy(repos = repos)
    }

    fun setSelectedRepo(selectedRepo: Repo) {
        state = state.copy(selectedRepo = selectedRepo)
    }

    private fun setLoadingRepos(loadingRepos: Boolean){
        state = state.copy(loadingRepos = loadingRepos)
    }

    fun requestRepos() {
        viewModelScope.launch {
            setLoadingRepos(true)
            try {
                withContext(Dispatchers.IO) { reposListCase.requestRepos()}.also(::setRepos)
                setStatus(Status.SUCCESS)
            } catch (e: Exception) {
                handleNetworkError(e)
            }
            finally {
                setLoadingRepos(false)
            }
        }
    }
}