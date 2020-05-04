package com.example.mvvm_dagger.di.components

import android.app.Application
import com.example.mvvm_dagger.BaseApplication
import com.example.mvvm_dagger.di.modules.ActivityBuildersModule
import com.example.mvvm_dagger.di.modules.AppModule
import com.example.mvvm_dagger.di.modules.ViewModelProviderFactoryModule
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

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}