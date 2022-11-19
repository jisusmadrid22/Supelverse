package com.yzdev.supelverse.domain.repository

import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBattleLogBsDto
import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBsDto

interface BrawlStarsRepository {

    //---------------------------------- API ----------------------------------------------
    /** Get player info from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    suspend fun getPlayerByTag(playerTag: String): PlayerBsDto

    /** Get player battle log from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    suspend fun getPlayerBattleLog(playerTag: String): PlayerBattleLogBsDto

    //-------------------------------------------------------------------------------------

    //------------------------------------- DATA BASE --------------------------------------

    //-------------------------------------------------------------------------------------
}