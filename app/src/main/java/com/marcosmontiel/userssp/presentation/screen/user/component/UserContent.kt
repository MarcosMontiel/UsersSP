package com.marcosmontiel.userssp.presentation.screen.user.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.userssp.R
import com.marcosmontiel.userssp.domain.model.User
import com.marcosmontiel.userssp.presentation.component.DefaultEmptyScreen
import com.marcosmontiel.userssp.presentation.screen.user.UserViewModel

@Composable
fun UserContent(
    modifier: Modifier,
    viewModel: UserViewModel = hiltViewModel(),
    navController: NavHostController,
    paddingValues: PaddingValues,
    users: List<User>,
) {

    Box(modifier = modifier.padding(paddingValues)) {

        if (users.isEmpty()) {

            DefaultEmptyScreen(
                image = R.drawable.ic_add_user,
                title = stringResource(R.string.empty_users_message),
                action = stringResource(R.string.empty_users_action),
            )

        }

    }

}