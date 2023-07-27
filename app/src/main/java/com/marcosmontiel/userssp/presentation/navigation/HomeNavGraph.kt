package com.marcosmontiel.userssp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.marcosmontiel.userssp.presentation.navigation.HomeRoutes.Users
import com.marcosmontiel.userssp.presentation.screen.user.UserScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(startDestination = Users.route, route = Graph.HOME) {

        composable(route = Users.route) {
            UserScreen(navController = navController)
        }

    }
}

sealed class HomeRoutes(val route: String) {

    object Users : HomeRoutes(route = "users")

}