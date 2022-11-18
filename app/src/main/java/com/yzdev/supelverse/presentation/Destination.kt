package com.yzdev.supelverse.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination(val screenRoute: String, val title: String, val icon: ImageVector){
    REGISTER_TAG(
        screenRoute = "SV_SCREEN:REGISTER_TAG",
        title = "Register Tag",
        icon = Icons.Rounded.Home
    ),
}