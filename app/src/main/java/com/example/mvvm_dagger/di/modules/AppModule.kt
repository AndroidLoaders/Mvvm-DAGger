package com.example.mvvm_dagger.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger.datamanager.AppDataManager
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.networkadapter.api.apimanager.ApiManager
import com.example.mvvm_dagger.networkadapter.api.apirequest.ApiRequest
import com.example.mvvm_dagger.preferences.PreferenceManager
import com.example.mvvm_dagger.preferences.PreferenceRequest
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.reflect.KClass

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