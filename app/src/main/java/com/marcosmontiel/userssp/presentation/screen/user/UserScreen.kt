package com.marcosmontiel.userssp.presentation.screen.user

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marcosmontiel.userssp.domain.model.User
import com.marcosmontiel.userssp.presentation.screen.user.component.UserContent
import com.marcosmontiel.userssp.presentation.ui.theme.Blue500

@ExperimentalMaterialApi
@Composable
fun UserScreen(navController: NavHostController) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {

            TopAppBar(
                title = { Text(text = "Usuarios") },
                navigationIcon = {

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = "menu icon",
                        )
                    }

                },
                actions = {

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "settings icon",
                        )
                    }

                },
                backgroundColor = Blue500,
                elevation = 24.dp,
            )

        },
        content = { paddingValues ->

            UserContent(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                paddingValues = paddingValues,
                users = User.getUsers(),
            )

        },
        bottomBar = {

            BottomAppBar {

            }

        },
        floatingActionButton = {

            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "FAB icon")
            }

        },
        isFloatingActionButtonDocked = false,
    )

}