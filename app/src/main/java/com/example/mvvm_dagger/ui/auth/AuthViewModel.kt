package com.example.mvvm_dagger.ui.auth

import com.example.mvvm_dagger.base.extensions.rx.autoDispose
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.ui.base.BaseViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

    private val TAG: String = "TAG --- ${AuthViewModel::class.java.simpleName} --->"

    fun observeLoadingData(): PublishSubject<Boolean> = isLoading

    fun authenticateUserWithId(userId: Int) {
        dataManager.getLoginUserDetails(userId)
            .doOnSubscribe { isLoading.onNext(true) }
            .subscribe({
                isLoading.onNext(false)
                dataManager.updateUserData(it)
            }, {
                isLoading.onNext(false)
                println("$TAG ${it.message}")
            }).autoDispose(disposables)
    }


    //private val authUser: MediatorLiveData<User> = MediatorLiveData()

    //fun observeUser(): LiveData<User> = authUser

    /*fun authenticateUserWithId(userId: Int) {
        val sourceData: LiveData<User> = LiveDataReactiveStreams.fromPublisher {
            dataManager.getLoginUserDetails(userId).subscribeOn(Schedulers.io())
        }

        authUser.addSource(sourceData) {
            authUser.value = it
            authUser.removeSource(sourceData)
            dataManager.updateUserData(it)
        }
    }*/
}