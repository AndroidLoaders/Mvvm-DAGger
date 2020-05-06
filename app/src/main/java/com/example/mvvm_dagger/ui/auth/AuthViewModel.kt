package com.example.mvvm_dagger.ui.auth

import androidx.lifecycle.ViewModel
import com.example.mvvm_dagger.base.extensions.rx.rxview.autoDispose
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.ui.base.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

    private val TAG: String = "TAG --- ${AuthViewModel::class.java.simpleName} --->"

    fun authenticateUserWithId(userId: Int) {
        dataManager.getLoginUserDetails(userId).doOnSubscribe { isLoading.onNext(true) }
            .subscribe({
                isLoading.onNext(false)
                dataManager.updateUserData(it.getUser())
            }, {
                isLoading.onNext(false)
                println("$TAG ${it.message}")
            }).autoDispose(disposables)
    }
}