package com.example.mvvm_dagger.networkadapter.api.apimanager

import com.example.mvvm_dagger.base.extensions.rx.subscribeAndObserveWithDelaySubscription
import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiInterface
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import io.reactivex.Single
import javax.inject.Inject

class ApiManager @Inject constructor(private val apiClient: ApiInterface) : ApiRequest {

    private val TAG: String = "TAG --- ${ApiManager::class.java.simpleName} --->"

    override fun getLoginUserDetails(userId: Int): Single<User> =
        apiClient.getLoginUserDetails(userId).subscribeAndObserveWithDelaySubscription()
}