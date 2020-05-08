package com.example.mvvm_dagger.ui.auth

import com.example.mvvm_dagger.networkadapter.api.response.ResponseStatus

class AuthResource<T>(
    responseStatus: ResponseStatus, mData: T?, private val message: String = ""
) {

    val status:ResponseStatus = responseStatus
    val data:T? = mData

    companion object {
        fun <T> authenticated(data: T): AuthResource<T> =
            AuthResource(ResponseStatus.Success, data)

        fun <T> loading(): AuthResource<T> = AuthResource(ResponseStatus.Loading, null)

        fun <T> error(message: String): AuthResource<T> =
            AuthResource(ResponseStatus.Error, null, message)

        fun <T> logout(): AuthResource<T> =
            AuthResource(ResponseStatus.NonAuthenticated, null, "")
    }
}