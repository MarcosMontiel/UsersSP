package com.marcosmontiel.userssp.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DefaultOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    valueChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = text,
        onValueChange = { valueChange(it) },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        singleLine = true,
        maxLines = 1,
    )

}