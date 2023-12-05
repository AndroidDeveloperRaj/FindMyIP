package com.example.mylibrary.utils

import com.example.mylibrary.model.FindMyIpModel

sealed class ApiState{

    class Success(val data: FindMyIpModel) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()

}