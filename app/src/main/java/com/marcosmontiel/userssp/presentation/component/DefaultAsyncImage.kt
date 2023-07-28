package com.marcosmontiel.userssp.presentation.component

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
import coil.compose.AsyncImage
import com.marcosmontiel.userssp.presentation.ui.theme.Gray900

@Composable
fun DefaultAsyncImage(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    background: Color = Gray900,
    fraction: Float = 1f,
    alpha: Float = 1f,
    image: Any,
) {

    Box(
        modifier = modifier
            .clip(shape)
            .background(background)
    ) {

        AsyncImage(
            model = image,
            contentDescription = "async image",
            modifier = Modifier
                .clip(shape)
                .fillMaxSize(fraction),
            contentScale = ContentScale.Crop,
            alpha = alpha,
        )

    }

}