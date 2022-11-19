package com.yzdev.supelverse.data.remote

import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBattleLogBsDto
import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BrawlStarsApi {

    /** Get player info by tag in brawl stars api
     * @param playerTag is tag associated to player profile
     * */
    @GET("players/{playerTag}")
    suspend fun getPlayerBs(@Path("playerTag") playerTag: String): PlayerBsDto

    /** Get player battle log in brawl stars api
     * @param playerTag is tag associated to player profile
     * */
    @GET("players/{playerTag}/battlelog")
    suspend fun getPlayerBattleLog(@Path("playerTag") playerTag: String): PlayerBattleLogBsDto
}