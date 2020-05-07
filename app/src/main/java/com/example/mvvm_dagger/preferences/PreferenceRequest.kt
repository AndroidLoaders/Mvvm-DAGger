package com.example.mvvm_dagger.preferences

interface PreferenceRequest {

    fun isLogin(): Boolean

    fun getUserId(): String
    fun setUserId(userId: String)

    fun getName(): String
    fun setName(name: String)

    fun getUserName(): String
    fun setUserName(userName: String)

    fun getEmailId(): String
    fun setEmailId(emailId: String)

    fun getPhoneNumber(): String
    fun setPhoneNumber(phoneNumber: String)

    fun getWebsite(): String
    fun setWebsite(website: String)

    fun getCompleteAddress(): String
    fun setCompleteAddress(address: String)
}