package com.example.mvvm_dagger.networkadapter.api.response

sealed class ResponseStatus {
    object Error : ResponseStatus()
    object Loading : ResponseStatus()
    object Success : ResponseStatus()
    object NonAuthenticated : ResponseStatus()
}