package com.example.mvvm_dagger.networkadapter.api.response

import com.example.mvvm_dagger.models.ApiStatus

interface ApiResponse<ResponseClass : ApiStatus> {
    fun onSuccess(apiName: String, apiResponse: ResponseClass)
    fun onFailed(apiName: String, throwable: Throwable)
}