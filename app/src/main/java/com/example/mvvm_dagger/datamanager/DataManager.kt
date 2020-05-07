package com.example.mvvm_dagger.datamanager

import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.networkadapter.api.requests.ApiRequest
import com.example.mvvm_dagger.preferences.PreferenceRequest

interface DataManager : ApiRequest, PreferenceRequest {
    fun updateUserData(user: User)
}