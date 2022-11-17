package com.yzdev.supelverse.data.repository

import com.yzdev.supelverse.data.remote.SupelverseApi
import com.yzdev.supelverse.data.remote.dto.PlayerBattleLogBsDto
import com.yzdev.supelverse.data.remote.dto.PlayerBsDto
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import javax.inject.Inject

class BrawlStarsRepositoryImp @Inject constructor(
    private val supelVerseApi: SupelverseApi
): BrawlStarsRepository {

    /** Get player info from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    override suspend fun getPlayerByTag(playerTag: String): PlayerBsDto {
        return supelVerseApi.getPlayerBs(playerTag)
    }

    /** Get player battle log from brawl stars api
     * @param playerTag is tag associated in profile
     * */
    override suspend fun getPlayerBattleLog(playerTag: String): PlayerBattleLogBsDto {
        return supelVerseApi.getPlayerBattleLog(playerTag)
    }

}