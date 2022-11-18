package com.yzdev.supelverse.presentation.screen.register_tag

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun RegisterTagScreen(
    viewModel: RegisterTagViewModel
) {
    val state = viewModel.state.value
    var tag by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = tag,
            onValueChange = {
                tag = it
            }
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Button(
            onClick = {
                scope.launch {
                    viewModel.getInfoPlayerBs(tag)
                }
            }
        ) {
            Text(text = "search")
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Text(text = "result-> ${state.info?.name} - ${state.info?.trophies}\nerror -> ${state.error}\nloading -> ${state.isLoading}")
    }
}