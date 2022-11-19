package com.yzdev.supelverse.presentation.screen.register_tag

import com.yzdev.supelverse.domain.model.brawl_stars.PlayerBs
import com.yzdev.supelverse.domain.model.clash_clans.PlayerCoc

data class PlayerInfoCocState(
    val isLoading: Boolean = false,
    val info: PlayerCoc? = null,
    val error: String = ""
)
