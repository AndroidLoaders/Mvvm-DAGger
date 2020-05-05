package com.example.mvvm_dagger.networkadapter.api.apirequest

import com.example.mvvm_dagger.networkadapter.apiconstants.ApiProvider
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiInterface {
    @GET(ApiProvider.ApiGetLoginUser)
    fun getLoginUserDetails(): Single<ResponseBody>
}

