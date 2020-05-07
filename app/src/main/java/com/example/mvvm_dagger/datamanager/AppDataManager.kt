package com.example.mvvm_dagger.datamanager

import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import com.example.mvvm_dagger.preferences.PreferenceRequest
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val apiRequest: ApiRequest, private val preferences: PreferenceRequest
) : DataManager {

    // ApiRequest Callbacks
    override fun getLoginUserDetails(userId: Int): Single<User> =
        apiRequest.getLoginUserDetails(userId)

    // PreferenceRequest Callbacks
    override fun updateUserData(user: User) {
        setUserId(user.getUserId())
        setEmailId(user.getEmailId())
        setName(user.getName())
        setUserName(user.getUserName())
        setWebsite(user.getWebsite())
        setPhoneNumber(user.getPhoneNumber())
        setCompleteAddress(user.getAddress())
    }

    override fun isLogin(): Boolean = preferences.isLogin()

    override fun getUserId(): String = preferences.getUserId()
    override fun setUserId(userId: String) = preferences.setUserId(userId)
    override fun getName(): String = preferences.getName()
    override fun setName(name: String) = preferences.setName(name)
    override fun getUserName(): String = preferences.getUserName()
    override fun setUserName(userName: String) = preferences.setUserName(userName)
    override fun getEmailId(): String = preferences.getEmailId()
    override fun setEmailId(emailId: String) = preferences.setEmailId(emailId)
    override fun getPhoneNumber(): String = preferences.getPhoneNumber()
    override fun setPhoneNumber(phoneNumber: String) = preferences.setPhoneNumber(phoneNumber)
    override fun getWebsite(): String = preferences.getWebsite()
    override fun setWebsite(website: String) = preferences.setWebsite(website)
    override fun getCompleteAddress(): String = preferences.getCompleteAddress()
    override fun setCompleteAddress(address: String) = preferences.setCompleteAddress(address)
}