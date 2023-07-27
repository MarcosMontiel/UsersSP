package com.marcosmontiel.userssp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Graph.HOME,
        route = Graph.ROOT,
    ) {

        homeNavGraph(navController = navController)

    }

}