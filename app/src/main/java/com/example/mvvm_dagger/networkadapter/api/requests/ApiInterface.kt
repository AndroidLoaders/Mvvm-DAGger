package com.example.mvvm_dagger.networkadapter.api.requests

import com.example.mvvm_dagger.models.Post
import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.networkadapter.apiconstants.ApiConstants
import com.example.mvvm_dagger.networkadapter.apiconstants.ApiProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET(ApiProvider.ApiGetLoginUser)
    fun getLoginUserDetails(@Path(ApiConstants.Id) id: Int): Single<User>

    @GET(ApiProvider.ApiGetPosts)
    fun getPosts(@Query(ApiConstants.UserId) userId: Int): Single<MutableList<Post>>
}

