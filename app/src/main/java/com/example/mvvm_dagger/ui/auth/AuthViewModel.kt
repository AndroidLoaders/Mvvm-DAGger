package com.example.mvvm_dagger.ui.auth

import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.ui.base.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

    private val TAG: String = "TAG --- ${AuthViewModel::class.java.simpleName} --->"

    fun showLog() =
        println("$TAG ${dataManager.getAccessToken()}")

}