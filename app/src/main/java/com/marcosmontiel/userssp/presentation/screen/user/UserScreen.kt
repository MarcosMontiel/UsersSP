package com.marcosmontiel.userssp.presentation.screen.user

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.marcosmontiel.userssp.domain.model.User
import com.marcosmontiel.userssp.presentation.screen.user.component.UserContent

@Composable
fun UserScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {}
    ) { paddingValues ->

        UserContent(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            paddingValues = paddingValues,
            users = listOf(
                User(
                    name = "Juan",
                    lastName = "Juarez",
                    url = "https://firebasestorage.googleapis.com/v0/b/games-learning.appspot.com/o/Posts%2F3ba3ac98-6487-4cd5-9dc8-5d00831e498f6845442358286615801.jpg?alt=media&token=f671ccdb-5fac-4bed-baaa-9394d2dddcc7"
                ),
                User(name = "Maria", lastName = "Juarez"),
                User(name = "Maria", lastName = "Juarez"),
                User(name = "Maria", lastName = "Juarez"),
            ),
        )

    }

}