package com.example.mvvm_dagger.networkadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<AuthResource<User?>> = MediatorLiveData()

    fun observeAuthUser(): LiveData<AuthResource<User?>> = cachedUser

    fun addLiveUser(authUser: AuthResource<User?>) {
        cachedUser.value = authUser
    }

    fun logoutUser() {
        cachedUser.value = AuthResource.logout()
    }
}