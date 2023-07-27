package com.marcosmontiel.userssp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marcosmontiel.userssp.presentation.ui.theme.Gray500

@Composable
fun DefaultEmptyScreen(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    action: String,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            DefaultDrawableRes(image = image, size = 128.dp)

            Spacer(modifier = Modifier.size(16.dp))

            DefaultText(text = title)

            Spacer(modifier = Modifier.size(8.dp))

            DefaultText(color = Gray500, text = action, style = MaterialTheme.typography.body2)

        }

    }
}