package com.yzdev.supelverse.presentation.screen.register_tag

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yzdev.supelverse.common.Resource
import com.yzdev.supelverse.domain.use_case.get_player_info.GetPlayerBsInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterTagViewModel @Inject constructor(
    private val getPlayerBsInfoUseCase: GetPlayerBsInfoUseCase
) : ViewModel(){

    private val _state = mutableStateOf(PlayerInfoBsState())
    val state: State<PlayerInfoBsState> = _state

    suspend fun getInfoPlayerBs(playerTag: String){
        getPlayerBsInfoUseCase(playerTag).onEach { result->
            when(result){
                is Resource.Error -> {
                    _state.value = PlayerInfoBsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = PlayerInfoBsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = PlayerInfoBsState(info = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}