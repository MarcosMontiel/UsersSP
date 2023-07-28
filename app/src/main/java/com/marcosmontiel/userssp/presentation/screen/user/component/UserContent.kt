package com.marcosmontiel.userssp.presentation.screen.user.component

import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.userssp.R
import com.marcosmontiel.userssp.domain.model.User
import com.marcosmontiel.userssp.presentation.component.DefaultAsyncImage
import com.marcosmontiel.userssp.presentation.component.DefaultEmptyScreen
import com.marcosmontiel.userssp.presentation.component.DefaultImage
import com.marcosmontiel.userssp.presentation.component.DefaultText
import com.marcosmontiel.userssp.presentation.screen.user.UserViewModel
import com.marcosmontiel.userssp.presentation.ui.theme.Gray800

@Composable
fun UserContent(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: UserViewModel = hiltViewModel(),
    preferences: SharedPreferences,
    paddingValues: PaddingValues,
    users: List<User>,
) {

    LaunchedEffect(Unit) {
        viewModel.assignPreference(preferences)
    }

    Box(modifier = modifier.padding(paddingValues)) {

        if (users.isEmpty()) {

            DefaultEmptyScreen(
                image = R.drawable.ic_add_user,
                title = stringResource(R.string.empty_users_message),
                action = stringResource(R.string.empty_users_action),
            )

        } else {

            UserRecyclerView(
                modifier = Modifier.fillMaxWidth(),
                navController = navController,
                users = users,
            )

        }

    }

}

@Composable
fun UserRecyclerView(
    modifier: Modifier,
    navController: NavHostController,
    users: List<User>,
) {

    LazyColumn(
        modifier = modifier,
        content = {

            itemsIndexed(users) { index, item ->

                val size: Int = users.size - 1
                val top: Dp = if (index == 0) 24.dp else 4.dp
                val bottom: Dp = if (index == size) 88.dp else 4.dp

                UserItem(
                    modifier = Modifier.padding(
                        top = top,
                        end = 8.dp,
                        bottom = bottom,
                        start = 8.dp
                    ),
                    navController = navController,
                    user = item,
                )

            }

        }
    )

}

@Composable
fun UserItem(
    modifier: Modifier,
    navController: NavHostController,
    user: User,
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(88.dp)
            .focusable()
            .clickable { },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Gray800,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            if (user.url.isNotEmpty()) {

                DefaultAsyncImage(modifier = Modifier.size(56.dp), image = user.url)

            } else {

                DefaultImage(modifier = Modifier.size(56.dp), image = R.drawable.ic_profile)

            }

            Spacer(modifier = Modifier.size(16.dp))

            DefaultText(text = user.getFullName())

        }

    }

}