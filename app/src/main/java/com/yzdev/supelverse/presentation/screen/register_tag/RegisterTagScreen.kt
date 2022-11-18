package com.yzdev.supelverse.presentation.screen.register_tag

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegisterTagScreen(
    viewModel: RegisterTagViewModel
) {
    val state = viewModel.state.value
    var tag by remember {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = tag,
            onValueChange = {
                tag = it
            }
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Button(
            onClick = {

            }
        ) {
            Text(text = "click")
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Text(text = "result-> ${state.info?.name}, error -> ${state.error}, loading -> ${state.isLoading}")
    }
}