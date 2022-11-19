package com.yzdev.supelverse.domain.use_case.brawl_stars.get_player_battle_log

import com.yzdev.supelverse.common.Resource
import com.yzdev.supelverse.domain.model.brawl_stars.PlayerBattleLogBs
import com.yzdev.supelverse.domain.model.brawl_stars.toPlayerBattleLogBs
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayerBsBattleLogUseCase @Inject constructor(
    private val repository: BrawlStarsRepository
) {
    operator fun invoke(playerTag: String): Flow<Resource<PlayerBattleLogBs>> = flow {
        try {
            emit(Resource.Loading())
            val playerInfo = repository.getPlayerBattleLog(playerTag).toPlayerBattleLogBs()
            emit(Resource.Success(playerInfo))

        } catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))

        }
    }
}