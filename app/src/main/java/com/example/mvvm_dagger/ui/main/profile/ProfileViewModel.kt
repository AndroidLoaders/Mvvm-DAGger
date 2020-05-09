package com.example.mvvm_dagger.ui.main.profile

import androidx.lifecycle.LiveData
import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.networkadapter.SessionManager
import com.example.mvvm_dagger.ui.auth.Resource
import com.example.mvvm_dagger.ui.base.BaseViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val sessionManager: SessionManager) :
    BaseViewModel() {

    private val TAG: String = "TAG ---${ProfileViewModel::class.java.simpleName} --->"

    fun observeAuthenticatedUser(): LiveData<Resource<User?>> = sessionManager.observeAuthUser()
}