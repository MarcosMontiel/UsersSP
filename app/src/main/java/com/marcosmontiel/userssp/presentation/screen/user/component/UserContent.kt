package com.marcosmontiel.userssp.presentation.screen.user.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcosmontiel.userssp.R
import com.marcosmontiel.userssp.domain.model.User
import com.marcosmontiel.userssp.presentation.component.*
import com.marcosmontiel.userssp.presentation.screen.user.UserState
import com.marcosmontiel.userssp.presentation.screen.user.UserViewModel
import com.marcosmontiel.userssp.presentation.ui.theme.Blue500
import com.marcosmontiel.userssp.presentation.ui.theme.Gray800
import com.marcosmontiel.userssp.presentation.ui.theme.Red400
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun UserContent(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: UserViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    users: List<User>,
) {

    val state: UserState = viewModel.state
    val username: String = viewModel.username ?: ""

    Box(modifier = modifier.padding(paddingValues)) {

        if (viewModel.isFirstTime && state.showAddUserDialog) {

            AddUserDialog(
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel,
                state = state,
            )

        }

        if (username.isNotEmpty()) {

            Toast.makeText(LocalContext.current, "Bienvenido, $username", Toast.LENGTH_LONG).show()

        }

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

@ExperimentalMaterialApi
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
                        end = 0.dp,
                        bottom = bottom,
                        start = 0.dp
                    ),
                    navController = navController,
                    user = item,
                )

            }

        }
    )

}

@ExperimentalMaterialApi
@Composable
fun UserItem(
    modifier: Modifier,
    navController: NavHostController,
    user: User,
) {

    val squareSize = 88.dp
    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)

    val swipeDp = swipeableState.offset.value.dp / 3

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(88.dp)
            .background(Gray800)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal,
            )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray800)
                .offset {
                    IntOffset(swipeableState.offset.value.roundToInt(), 0)
                }
                .focusable()
                .clickable { }
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
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

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(if (swipeDp > squareSize) squareSize else swipeDp)
                .background(Red400)
                .focusable()
                .clickable { },
            contentAlignment = Alignment.Center,
        ) {
            Icon(imageVector = Icons.Rounded.Delete, contentDescription = "delete icon")
        }

    }

}

@Composable
fun AddUserDialog(
    modifier: Modifier,
    viewModel: UserViewModel,
    state: UserState,
) {

    val errorMessage = stringResource(R.string.user_invalid_username)

    Dialog(onDismissRequest = { }) {

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Gray800)
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {

                DefaultText(
                    fontWeight = FontWeight.Bold,
                    text = stringResource(R.string.user_title_user_register),
                )

                Spacer(modifier = Modifier.size(24.dp))

                DefaultOutlinedTextField(
                    label = stringResource(R.string.user_title_username),
                    text = state.username,
                    valueChange = { viewModel.valueChange(maxLength = 20, username = it) }
                )

                Spacer(modifier = Modifier.size(16.dp))

                Box(modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .align(Alignment.End)
                    .clickable {

                        viewModel.saveUser(errorMessage = errorMessage)

                    }
                ) {

                    DefaultText(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        fontWeight = FontWeight.Bold,
                        color = Blue500,
                        text = stringResource(R.string.generic_title_register),
                    )

                }

            }

        }

    }

}