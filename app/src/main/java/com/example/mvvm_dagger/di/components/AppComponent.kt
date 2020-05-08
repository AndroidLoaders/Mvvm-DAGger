package com.example.mvvm_dagger.di.components

import android.app.Application
import com.example.mvvm_dagger.BaseApplication
import com.example.mvvm_dagger.di.modules.ActivityBuildersModule
import com.example.mvvm_dagger.di.modules.AppModule
import com.example.mvvm_dagger.di.modules.FragmentBuilderModule
import com.example.mvvm_dagger.di.modules.ViewModelProviderFactoryModule
import com.example.mvvm_dagger.networkadapter.SessionManager
import com.example.mvvm_dagger.networkadapter.api.requests.ApiInterface
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, ViewModelProviderFactoryModule::class,
        ActivityBuildersModule::class, AppModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    fun sessionManager(): SessionManager

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(application: Application): Builder

        @BindsInstance
        fun bindApiClient(apiClient: ApiInterface): Builder

        /**
         * If you want to instantiate PreferenceManager and ApiManager using below methods
         * then remove it from AppModule class and create instances in BaseApplication class
         * by calling this methods manually.
         *
         * @BindsInstance
         * fun bindPreferences(preference: PreferenceRequest): Builder

         * @BindsInstance
         * fun bindApiManager(apiRequest:ApiRequest): Builder
         */

        fun build(): AppComponent
    }
}