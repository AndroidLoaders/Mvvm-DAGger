package com.example.mvvm_dagger.di.modules

import com.example.mvvm_dagger.datamanager.AppDataManager
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.networkadapter.api.manager.ApiManager
import com.example.mvvm_dagger.networkadapter.api.requests.ApiRequest
import com.example.mvvm_dagger.preferences.PreferenceManager
import com.example.mvvm_dagger.preferences.PreferenceRequest
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Singleton
    @Binds
    protected abstract fun bindPreferenceManager(dataManager: PreferenceManager): PreferenceRequest

    @Singleton
    @Binds
    protected abstract fun bindApiManager(apiManager: ApiManager): ApiRequest

    @Singleton
    @Binds
    protected abstract fun bindDataManager(dataManager: AppDataManager): DataManager
}