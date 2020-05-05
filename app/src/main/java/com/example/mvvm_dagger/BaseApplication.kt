package com.example.mvvm_dagger

import com.example.mvvm_dagger.di.components.DaggerAppComponent
import com.example.mvvm_dagger.networkadapter.retrofit.RetrofitClient
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().bindApplication(this)
            .bindApiClient(RetrofitClient.createApiClient(this))
            .build()
}