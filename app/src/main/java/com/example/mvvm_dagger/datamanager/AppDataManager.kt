package com.example.mvvm_dagger.datamanager

import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import com.example.mvvm_dagger.preferences.PreferenceRequest
import com.example.mvvm_dagger.repository.UserRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val apiRequest: ApiRequest, private val preferences: PreferenceRequest
) : DataManager {

    // ApiRequest Callbacks
    override fun getLoginUserDetails(userId:Int): Single<UserRepository> = apiRequest.getLoginUserDetails(userId)

    // PreferenceRequest Callbacks
    override fun isLogin(): Boolean = preferences.isLogin()

    override fun updateUserData(user: User) {
        /*setAccessToken(user.accessToken!!)
        setUserId(user.userId!!)
        setUserName(user.userName!!)
        setEmailId(user.emailId!!)*/
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