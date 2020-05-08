package com.example.mvvm_dagger.models

abstract class ApiStatus {

    var status: String? = "0"
        get() = field ?: "0"
        set(value) {
            field = value ?: "0"
        }

    var message: String? = ""
        get() = field ?: ""
        set(value) {
            field = value ?: "0"
        }
}