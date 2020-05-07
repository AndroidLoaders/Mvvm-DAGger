package com.example.mvvm_dagger.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.models.User
import com.example.mvvm_dagger.ui.base.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

    private val TAG: String = "TAG --- ${AuthViewModel::class.java.simpleName} --->"

    private val authUser: MediatorLiveData<User> = MediatorLiveData()

    fun observeUser(): LiveData<User> = authUser

    fun authenticateUserWithId(userId: Int) {

        val sourceData: LiveData<User> = LiveDataReactiveStreams.fromPublisher {
            dataManager.getLoginUserDetails(userId)
        }

        authUser.addSource(sourceData) {
            authUser.value = it
            authUser.removeSource(sourceData)
        }

        /*dataManager.getLoginUserDetails(userId).doOnSubscribe { isLoading.onNext(true) }
            .subscribe({
                isLoading.onNext(false)
                dataManager.updateUserData(it)
            }, {
                isLoading.onNext(false)
                println("$TAG ${it.message}")
            }).autoDispose(disposables)*/
    }
}