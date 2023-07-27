package com.marcosmontiel.userssp.presentation.screen.user

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
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
        )

    }

}