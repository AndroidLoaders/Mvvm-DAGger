package com.example.mvvm_dagger.ui.auth

import com.example.mvvm_dagger.networkadapter.api.response.ResponseStatus

class Resource<T>(
    responseStatus: ResponseStatus, mData: T?, private val message: String = ""
) {

    val status:ResponseStatus = responseStatus
    val data:T? = mData

    companion object {
        fun <T> success(data: T): Resource<T> = Resource(ResponseStatus.Success, data)

        fun <T> loading(): Resource<T> = Resource(ResponseStatus.Loading, null)

        fun <T> error(message: String): Resource<T> =
            Resource(ResponseStatus.Error, null, message)

        fun <T> logout(): Resource<T> =
            Resource(ResponseStatus.NonAuthenticated, null, "")
    }
}