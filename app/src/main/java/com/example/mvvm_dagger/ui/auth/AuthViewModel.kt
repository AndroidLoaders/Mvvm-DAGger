package com.example.mvvm_dagger.ui.auth

import com.example.mvvm_dagger.base.extensions.rx.autoDispose
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.networkadapter.SessionManager
import com.example.mvvm_dagger.ui.base.BaseViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val dataManager: DataManager, private val sessionManager: SessionManager
) : BaseViewModel() {

    private val TAG: String = "TAG --- ${AuthViewModel::class.java.simpleName} --->"

    fun observeAuthUser() = sessionManager.observeAuthUser()

    fun authenticateUserWithId(userId: Int) {
        dataManager.getLoginUserDetails(userId)
            .doOnSubscribe { sessionManager.addLiveUser(AuthResource.loading()) }
            .doOnSuccess { sessionManager.addLiveUser(AuthResource.authenticated(it)) }
            .doOnError { sessionManager.addLiveUser(AuthResource.error(it.message ?: "")) }
            .subscribe({ dataManager.updateUserData(it) },
                { println("$TAG ${it.message}") })
            .autoDispose(disposables)
    }

    /*private val authUser: MediatorLiveData<User> = MediatorLiveData()

    fun observeUser(): LiveData<User> = authUser

    fun authenticateUserWithId(userId: Int) {
        val source: LiveData<User> = LiveDataReactiveStreams.fromPublisher {
            apiClient.getLoginUser(userId).toFlowable(BackpressureStrategy.BUFFER)
                .onErrorReturn {
                    println("$TAG ${it.message}")
                    User()
                }
                .map {
                    println("$TAG ${it.getUserId()}")
                    it
                }.subscribeOn(Schedulers.io())
        }

        authUser.addSource(source) {
            authUser.value = it
           // authUser.removeSource(sourceData)
         //   dataManager.updateUserData(it)
        }
    }*/
}