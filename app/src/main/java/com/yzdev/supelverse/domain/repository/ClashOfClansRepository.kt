package com.yzdev.supelverse.domain.repository

import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBattleLogBsDto
import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBsDto
import com.yzdev.supelverse.data.remote.dto.clash_clans.PlayerCocDto

interface ClashOfClansRepository {

    //---------------------------------- API ----------------------------------------------
    /** Get player info from clash of clans api
     * @param playerTag is tag associated in profile
     * */
    suspend fun getPlayerCocByTag(playerTag: String): PlayerCocDto

    //-------------------------------------------------------------------------------------

    //------------------------------------- DATA BASE --------------------------------------

    //-------------------------------------------------------------------------------------
}