package com.example.mvvm_dagger.networkadapter.apiconstants

import com.example.mvvm_dagger.BuildConfig

object ApiProvider {

    private const val GET_LOGIN_USER = "users/{${ApiConstants.Id}}"
    const val ApiGetLoginUser = BuildConfig.BASE_URL + GET_LOGIN_USER

    private const val GET_POSTS = "posts?${ApiConstants.UserId}="
    const val ApiGetPosts = BuildConfig.BASE_URL + GET_POSTS
}