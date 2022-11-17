package com.yzdev.supelverse.domain.use_case.get_player_info

import com.yzdev.supelverse.common.Resource
import com.yzdev.supelverse.data.remote.dto.PlayerBsDto
import com.yzdev.supelverse.domain.model.PlayerBs
import com.yzdev.supelverse.domain.model.toPlayerBs
import com.yzdev.supelverse.domain.repository.BrawlStarsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayerBsInfoUseCase @Inject constructor(
    private val repository: BrawlStarsRepository
) {
    operator fun invoke(playerTag: String): Flow<Resource<PlayerBs>> = flow {
        try {
            emit(Resource.Loading())
            val playerInfo = repository.getPlayerByTag(playerTag).toPlayerBs()
            emit(Resource.Success(playerInfo))

        } catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))

        }
    }
}