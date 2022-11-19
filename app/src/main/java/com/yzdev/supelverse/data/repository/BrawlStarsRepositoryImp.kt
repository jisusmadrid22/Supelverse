package com.yzdev.supelverse.data.repository

import com.yzdev.supelverse.data.remote.BrawlStarsApi
import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBattleLogBsDto
import com.yzdev.supelverse.data.remote.dto.brawl_stars.PlayerBsDto
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import javax.inject.Inject

class BrawlStarsRepositoryImp @Inject constructor(
    private val brawlStarsApi: BrawlStarsApi
): BrawlStarsRepository {

    /** Get player info from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    override suspend fun getPlayerByTag(playerTag: String): PlayerBsDto {
        return brawlStarsApi.getPlayerBs(playerTag)
    }

    /** Get player battle log from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    override suspend fun getPlayerBattleLog(playerTag: String): PlayerBattleLogBsDto {
        return brawlStarsApi.getPlayerBattleLog(playerTag)
    }

}