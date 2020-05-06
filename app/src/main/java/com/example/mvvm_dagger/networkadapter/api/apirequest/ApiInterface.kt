package com.example.mvvm_dagger.networkadapter.api.apirequest

import com.example.mvvm_dagger.networkadapter.apiconstants.ApiConstants
import com.example.mvvm_dagger.networkadapter.apiconstants.ApiProvider
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET(ApiProvider.ApiGetLoginUser)
    fun getLoginUserDetails(@Path(ApiConstants.Id) id: Int): Single<ResponseBody>
}

