package com.example.mvvm_dagger.networkadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.ui.auth.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val cachedUser: MediatorLiveData<Resource<User?>> = MediatorLiveData()

    fun observeAuthUser(): LiveData<Resource<User?>> = cachedUser

    fun addLiveUser(user: Resource<User?>) {
        cachedUser.value = user
    }

    fun logoutUser() {
        cachedUser.value = Resource.logout()
    }
}