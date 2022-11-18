package com.yzdev.supelverse.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yzdev.supelverse.presentation.screen.register_tag.RegisterTagScreen
import com.yzdev.supelverse.presentation.screen.register_tag.RegisterTagViewModel

@Composable
fun Navigation() {
    val navigation = rememberNavController()

    NavHost(
        navController = navigation,
        startDestination = Destination.REGISTER_TAG.screenRoute
    ){
        composable(
            route = Destination.REGISTER_TAG.screenRoute
        ){
            val viewmodel = hiltViewModel<RegisterTagViewModel>()

            Box(modifier = Modifier.fillMaxSize()){
                RegisterTagScreen(
                    viewModel = viewmodel
                )
            }
        }
    }
}