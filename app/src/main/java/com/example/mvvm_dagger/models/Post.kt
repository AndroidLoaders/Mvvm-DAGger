package com.example.mvvm_dagger.models

import com.example.mvvm_dagger.networkadapter.apiconstants.ApiConstants
import com.google.gson.annotations.SerializedName

/**
 * {
"userId": 1,
"id": 1,
"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
"body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
 */
data class Post(

    private val id: String? = "",

    private val title: String? = "",

    private val body: String? = "",

    @SerializedName(ApiConstants.UserId)
    private val userId: String? = ""
) {
    fun getId(): String = id ?: ""
    fun getUserId(): String = userId ?: ""
    fun getTitle(): String = title ?: ""
    fun getBody(): String = body ?: ""
}