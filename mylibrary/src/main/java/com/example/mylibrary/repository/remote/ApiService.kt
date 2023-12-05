package com.example.mylibrary.repository.remote

import com.example.mylibrary.constants.AppConstant
import com.example.mylibrary.model.FindMyIpModel
import retrofit2.http.GET

interface ApiService {
    @GET(AppConstant.API)
    suspend fun getIP(): FindMyIpModel
}