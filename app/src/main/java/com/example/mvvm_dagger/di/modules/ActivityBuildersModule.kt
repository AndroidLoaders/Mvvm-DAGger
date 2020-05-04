package com.example.mvvm_dagger.di.modules

import com.example.mvvm_dagger.di.modules.auth.AuthViewModelModule
import com.example.mvvm_dagger.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}