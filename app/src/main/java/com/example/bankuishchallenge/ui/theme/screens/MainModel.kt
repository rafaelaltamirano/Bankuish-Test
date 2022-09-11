package com.example.bankuishchallenge.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Repo
import com.example.usecases.MainCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor(
    private val mainCase: MainCase
) : ViewModelWithStatus() {

    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            delay(2000)
            setShowSplash(false)
        }
    }



    private fun setShowSplash(showSplash: Boolean){
        state = state.copy(showSplash = showSplash)
    }



}
