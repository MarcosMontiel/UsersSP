package com.marcosmontiel.userssp.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.marcosmontiel.userssp.presentation.ui.theme.Gray900

@Composable
fun DefaultImage(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    background: Color = Gray900,
    fraction: Float = 1f,
    alpha: Float = 1f,
    @DrawableRes image: Int,
) {

    Box(
        modifier = modifier
            .clip(shape)
            .background(background)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = "async image",
            modifier = Modifier
                .clip(shape)
                .fillMaxSize(fraction),
            contentScale = ContentScale.Crop,
            alpha = alpha,
        )

    }

}