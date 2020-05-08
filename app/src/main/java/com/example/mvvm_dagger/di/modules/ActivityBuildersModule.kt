package com.example.mvvm_dagger.di.modules

import com.example.mvvm_dagger.di.modules.auth.AuthViewModelModule
import com.example.mvvm_dagger.di.modules.main.MainViewModelModule
import com.example.mvvm_dagger.ui.auth.AuthActivity
import com.example.mvvm_dagger.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    /**
     * @ContributesAndroidInjector is used only for Activity and Fragments so that
     * so that when we need their object we can get from Dagger at any point of time.
     *
     * Basically it will generate SubComponent internally.
     */

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class])
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [FragmentBuilderModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}