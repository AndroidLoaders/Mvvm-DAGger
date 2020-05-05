package com.example.mvvm_dagger.networkadapter.api.apimanager

import com.example.mvvm_dagger.base.extensions.rx.subscribeAndObserveWithDelaySubscription
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiInterface
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import com.example.mvvm_dagger.ui.auth.AuthActivity
import io.reactivex.Single
import okhttp3.ResponseBody
import javax.inject.Inject

class ApiManager @Inject constructor(private val apiClient: ApiInterface) : ApiRequest {

    override fun getLoginUserDetails(): Single<ResponseBody> {
        if (apiClient != null)
            println("${AuthActivity.TAG} ApiManager injected")
        return apiClient.getLoginUserDetails().subscribeAndObserveWithDelaySubscription()
    }
}