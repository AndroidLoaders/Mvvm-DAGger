package com.example.mvvm_dagger.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.base.extensions.getString
import com.example.mvvm_dagger.base.extensions.putString
import javax.inject.Inject

class PreferenceManager @Inject constructor(application: Application) : PreferenceRequest {

    private val preferences: SharedPreferences by lazy {
        application.getSharedPreferences(
            application.getString(R.string.app_name), Context.MODE_PRIVATE
        )
    }

    override fun isLogin(): Boolean = getEmailId() != ""

    override fun getUserId(): String = preferences.getString(PreferenceConstants.UserId)!!

    override fun setUserId(userId: String) =
        preferences.putString(PreferenceConstants.UserId, userId)

    override fun getUserName(): String = preferences.getString(PreferenceConstants.UserName)!!

    override fun setUserName(userName: String) =
        preferences.putString(PreferenceConstants.UserName, userName)

    override fun getEmailId(): String = preferences.getString(PreferenceConstants.EmailId)!!

    override fun setEmailId(emailId: String) =
        preferences.putString(PreferenceConstants.EmailId, emailId)

    override fun getAccessToken(): String =
        preferences.getString(PreferenceConstants.AccessToken)!!

    override fun setAccessToken(accessToken: String) =
        preferences.putString(PreferenceConstants.AccessToken, accessToken)
}