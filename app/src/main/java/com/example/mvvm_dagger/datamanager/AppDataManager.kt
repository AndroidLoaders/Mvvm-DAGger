package com.example.mvvm_dagger.datamanager

import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import com.example.mvvm_dagger.preferences.PreferenceRequest
import io.reactivex.Single
import okhttp3.ResponseBody
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val apiRequest: ApiRequest, private val preferences: PreferenceRequest
) : DataManager {

    // ApiRequest Callbacks
    override fun getLoginUserDetails(): Single<ResponseBody> = apiRequest.getLoginUserDetails()

    // PreferenceRequest Callbacks
    override fun isLogin(): Boolean = preferences.isLogin()

    override fun updateUserData() {
        /*setAccessToken(loginResponse.accessToken!!)
        setUserId(loginResponse.userId!!)
        setUserName(loginResponse.userName!!)
        setEmailId(loginResponse.emailId!!)*/
    }

    override fun getUserId(): String = preferences.getUserId()
    override fun setUserId(userId: String) = preferences.setUserId(userId)
    override fun getUserName(): String = preferences.getUserName()
    override fun setUserName(userName: String) = preferences.setUserName(userName)
    override fun getEmailId(): String = preferences.getEmailId()
    override fun setEmailId(emailId: String) = preferences.setEmailId(emailId)
    override fun getAccessToken(): String = preferences.getAccessToken()
    override fun setAccessToken(accessToken: String) = preferences.setAccessToken(accessToken)
}