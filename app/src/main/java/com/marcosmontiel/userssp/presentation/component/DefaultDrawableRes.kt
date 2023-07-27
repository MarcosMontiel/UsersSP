package com.marcosmontiel.userssp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultDrawableRes(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    size: Dp = 96.dp,
) {

    Image(
        painter = painterResource(id = image),
        contentDescription = "empty list",
        modifier = modifier.size(size),
    )

}