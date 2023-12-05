package com.example.mylibrary.repository.remote

import com.example.mylibrary.model.FindMyIpModel
import com.example.mylibrary.repository.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    fun getIp(): Flow<FindMyIpModel> = flow {
        emit(apiService.getIP())
    }.flowOn(Dispatchers.IO)
}