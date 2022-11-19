package com.yzdev.supelverse.domain.use_case.clash_clans.get_player_info

import com.yzdev.supelverse.common.Resource
import com.yzdev.supelverse.domain.model.brawl_stars.PlayerBs
import com.yzdev.supelverse.domain.model.brawl_stars.toPlayerBs
import com.yzdev.supelverse.domain.model.clash_clans.PlayerCoc
import com.yzdev.supelverse.domain.model.clash_clans.toPlayerCoc
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import com.yzdev.supelverse.domain.repository.ClashOfClansRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayerCocInfoUseCase @Inject constructor(
    private val repository: ClashOfClansRepository
) {
    operator fun invoke(playerTag: String): Flow<Resource<PlayerCoc>> = flow {
        try {
            emit(Resource.Loading())
            val playerInfo = repository.getPlayerCocByTag(playerTag).toPlayerCoc()
            emit(Resource.Success(playerInfo))

        } catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))

        }
    }
}