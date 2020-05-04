package com.example.mvvm_dagger.di.modules.auth

import androidx.lifecycle.ViewModel
import com.example.mvvm_dagger.di.annotations.ViewModelKey
import com.example.mvvm_dagger.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindViewModel(viewModel: AuthViewModel): ViewModel

    /*@Provides
    @ViewModelKey(AuthViewModel::class)
    fun provideViewModel(viewModel: AuthViewModel): ViewModel = viewModel*/
}