package com.yzdev.supelverse.data.repository

import com.yzdev.supelverse.data.remote.BrawlStarsApi
import com.yzdev.supelverse.data.remote.ClashOfClansApi
import com.yzdev.supelverse.data.remote.dto.clash_clans.PlayerCocDto
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import com.yzdev.supelverse.domain.repository.ClashOfClansRepository
import javax.inject.Inject

class ClashOfClansRepositoryImp @Inject constructor(
    private val clashOfClansApi: ClashOfClansApi
): ClashOfClansRepository {

    /** Get player info from clash of clans api
     * @param playerTag is tag associated in profile
     * */
    override suspend fun getPlayerCocByTag(playerTag: String): PlayerCocDto {
        return clashOfClansApi.getPlayerCoc(playerTag)
    }

}