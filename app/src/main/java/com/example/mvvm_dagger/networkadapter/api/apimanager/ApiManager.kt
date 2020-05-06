package com.example.mvvm_dagger.networkadapter.api.apimanager

import com.example.mvvm_dagger.base.extensions.rx.subscribeAndObserveWithDelaySubscription
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiInterface
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import com.example.mvvm_dagger.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class ApiManager @Inject constructor(private val apiClient: ApiInterface) : ApiRequest {

    private val TAG: String = "TAG --- ${ApiManager::class.java.simpleName} --->"

    override fun getLoginUserDetails(userId: Int): Single<UserRepository> =
        apiClient.getLoginUserDetails(userId).subscribeAndObserveWithDelaySubscription()
}