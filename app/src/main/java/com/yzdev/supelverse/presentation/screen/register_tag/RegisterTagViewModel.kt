package com.yzdev.supelverse.presentation.screen.register_tag

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yzdev.supelverse.common.Resource
import com.yzdev.supelverse.domain.use_case.brawl_stars.get_player_info.GetPlayerBsInfoUseCase
import com.yzdev.supelverse.domain.use_case.clash_clans.get_player_info.GetPlayerCocInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RegisterTagViewModel @Inject constructor(
    private val getPlayerBsInfoUseCase: GetPlayerBsInfoUseCase,
    private val getPlayerCocInfoUseCase: GetPlayerCocInfoUseCase
) : ViewModel(){

    private val _stateBs = mutableStateOf(PlayerInfoBsState())
    val stateBs: State<PlayerInfoBsState> = _stateBs

    private val _stateCoc = mutableStateOf(PlayerInfoCocState())
    val stateCoc: State<PlayerInfoCocState> = _stateCoc

    suspend fun getInfoPlayerBs(playerTag: String){
        getPlayerBsInfoUseCase(playerTag).onEach { result->
            when(result){
                is Resource.Error -> {
                    _stateBs.value = PlayerInfoBsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _stateBs.value = PlayerInfoBsState(isLoading = true)
                }
                is Resource.Success -> {
                    _stateBs.value = PlayerInfoBsState(info = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    suspend fun getInfoPlayerCoc(playerTag: String){
        getPlayerCocInfoUseCase(playerTag).onEach { result->
            when(result){
                is Resource.Error -> {
                    _stateCoc.value = PlayerInfoCocState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _stateCoc.value = PlayerInfoCocState(isLoading = true)
                }
                is Resource.Success -> {
                    _stateCoc.value = PlayerInfoCocState(info = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}