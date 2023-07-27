package com.marcosmontiel.userssp.presentation.screen.user.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.userssp.presentation.screen.user.UserViewModel

@Composable
fun UserContent(
    modifier: Modifier,
    viewModel: UserViewModel = hiltViewModel(),
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    Box(modifier = modifier.padding(paddingValues)) {

    }

}