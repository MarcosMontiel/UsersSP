package com.marcosmontiel.userssp.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultOutlinedTextField(
    modifier: Modifier = Modifier,
    maxLength: Int = 20,
    label: String,
    text: String,
    valueChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = text,
        onValueChange = { valueChange(it) },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        trailingIcon = {

            val currentLength = text.length

            DefaultText(
                modifier = Modifier.padding(end = 16.dp),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
                text = "$currentLength/$maxLength",
            )

        },
        singleLine = true,
        maxLines = 1,
    )

}