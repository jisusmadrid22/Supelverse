package com.yzdev.supelverse.data.remote

import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBsDto
import com.yzdev.supelverse.data.remote.dto.clash_clans.PlayerCocDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ClashOfClansApi {

    /** Get player info by tag in clash of clans api
     * @param playerTag is tag associated to player profile
     * */
    @GET("players/{playerTag}")
    suspend fun getPlayerCoc(@Path("playerTag") playerTag: String): PlayerCocDto
}