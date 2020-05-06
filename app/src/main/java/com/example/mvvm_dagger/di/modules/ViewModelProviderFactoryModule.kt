package com.example.mvvm_dagger.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger.ui.auth.AuthActivity
import com.example.mvvm_dagger.ui.auth.AuthViewModel
import com.example.mvvm_dagger.viewmodelproviderfactory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelProviderFactoryModule {

    /**
     * If you want to use provideViewModelProviderFactory method then remove
     * bindViewModelProviderFactory method below
     *
     * @Provides
     * fun provideViewModelProviderFactory(factory: ViewModelProviderFactory):
     * ViewModelProvider.Factory = factory
     */
    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelProviderFactory):
            ViewModelProvider.Factory
}