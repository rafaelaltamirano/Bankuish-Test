package com.example.bankuishchallenge.ui.theme.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankuishchallenge.ui.theme.router.Routers.*
import com.example.bankuishchallenge.ui.theme.screens.MainModel
import com.example.bankuishchallenge.ui.theme.screens.repos.ReposListModel
import com.example.bankuishchallenge.ui.theme.screens.repos.ReposListScreen
import com.example.bankuishchallenge.ui.theme.screens.reposDetails.ReposDetailsScreen
import com.example.bankuishchallenge.ui.theme.screens.splash.SplashScreen

@Composable
fun Router(mainModel: MainModel = viewModel()) {

    val navController = rememberNavController()
    val reposModel = hiltViewModel<ReposListModel>()

    NavHost(
        navController = navController,
        startDestination = if (mainModel.state.showSplash) SPLASH.route else MAIN.route
    ) {
        composable(SPLASH.route) { SplashScreen() }
        composable(MAIN.route) {

            ReposListScreen(model = reposModel, mainModel = mainModel,navController = navController)
        }
        composable(REPO_DETAILS.route) {
            ReposDetailsScreen(model = reposModel, mainModel = mainModel)
        }
    }
}