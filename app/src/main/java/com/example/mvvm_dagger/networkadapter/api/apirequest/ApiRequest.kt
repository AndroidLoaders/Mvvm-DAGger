package com.example.mvvm_dagger.networkadapter.api.apirequest

import com.example.mvvm_dagger.repository.UserRepository
import io.reactivex.Single

interface ApiRequest {
    fun getLoginUserDetails(userId: Int): Single<UserRepository>
}