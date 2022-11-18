package com.yzdev.supelverse.presentation.screen.register_tag

import com.yzdev.supelverse.domain.model.PlayerBs

data class PlayerInfoBsState(
    val isLoading: Boolean = false,
    val info: PlayerBs? = null,
    val error: String = ""
)
