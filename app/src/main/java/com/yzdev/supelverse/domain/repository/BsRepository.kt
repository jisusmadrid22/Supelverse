package com.yzdev.supelverse.domain.repository

import com.yzdev.supelverse.data.remote.dto.PlayerBsDto

interface BsRepository {

    //---------------------------------- API ----------------------------------------------
    /** Get player info from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    suspend fun getPlayerByTag(playerTag: String): PlayerBsDto

    /** Get player battle log from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    suspend fun getPlayerBattleLog(playerTag: String): PlayerBsDto

    //-------------------------------------------------------------------------------------

    //------------------------------------- DATA BASE --------------------------------------

    //-------------------------------------------------------------------------------------
}