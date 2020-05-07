package com.example.mvvm_dagger.networkadapter.api.apirequest

import com.example.mvvm_dagger.models.User
import io.reactivex.Single

interface ApiRequest {
    fun getLoginUserDetails(userId: Int): Single<User>
}