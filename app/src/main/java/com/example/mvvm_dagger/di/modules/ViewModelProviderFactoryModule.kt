package com.example.mvvm_dagger.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger.viewmodelproviderfactory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderFactoryModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelProviderFactory):
            ViewModelProvider.Factory

    /*@Provides
    fun provideViewModelProviderFactory(factory: ViewModelProviderFactory):
            ViewModelProvider.Factory = factory*/
}