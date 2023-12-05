package com.example.mylibrary.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibrary.repository.remote.MainRepository
import com.example.mylibrary.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMyIPViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)
    init {
        getIp()
    }

    private fun getIp() = viewModelScope.launch {
        repository.getIp()
                .onStart {
                    response.value = ApiState.Loading
                }.catch {
                    response.value = ApiState.Failure(it)
                }.collect {
                    response.value = ApiState.Success(it)
                }
    }
}