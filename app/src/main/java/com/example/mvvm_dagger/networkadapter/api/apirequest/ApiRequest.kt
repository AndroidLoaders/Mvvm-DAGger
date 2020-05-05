package com.example.mvvm_dagger.networkadapter.api.apirequest

import io.reactivex.Single
import okhttp3.ResponseBody

interface ApiRequest {
    fun getLoginUserDetails(): Single<ResponseBody>
}