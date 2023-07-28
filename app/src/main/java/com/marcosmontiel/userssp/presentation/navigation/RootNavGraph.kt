package com.marcosmontiel.userssp.presentation.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun RootNavGraph(navController: NavHostController, preferences: SharedPreferences) {

    NavHost(
        navController = navController,
        startDestination = Graph.HOME,
        route = Graph.ROOT,
    ) {

        homeNavGraph(navController = navController, preferences = preferences)

    }

}