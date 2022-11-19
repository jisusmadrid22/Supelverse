package com.yzdev.supelverse.presentation.screen.register_tag

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun RegisterTagScreen(
    viewModel: RegisterTagViewModel
) {
    val state = viewModel.stateBs.value
    val stateCoc = viewModel.stateCoc.value
    var tag by remember {
        mutableStateOf("")
    }

    var tagCoc by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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

        Spacer(modifier = Modifier.padding(8.dp))

        Column {
            TextField(
                value = tagCoc,
                onValueChange = {
                    tagCoc = it
                }
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Button(
                onClick = {
                    scope.launch {
                        viewModel.getInfoPlayerCoc(tagCoc)
                    }
                }
            ) {
                Text(text = "search coc")
            }

            Spacer(modifier = Modifier.padding(4.dp))

            Text(text = "result-> ${stateCoc.info?.name} - ${stateCoc.info?.trophies}\nerror -> ${stateCoc.error}\nloading -> ${stateCoc.isLoading}")
        }
    }
}