package com.example.mvvm_dagger.di.modules.auth

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger.di.annotations.ViewModelKey
import com.example.mvvm_dagger.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class AuthViewModelModule {

    /**
     * * @Provides
     * @IntoMap
     * @ViewModelKey(AuthViewModel::class)
     * fun provideViewModel(viewModel: AuthViewModel): ViewModel = viewModel
     *
     * If you want to use @Provides annotation same as above then remove bindViewModel
     * method below
     *
     * */
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindViewModel(viewModel: AuthViewModel): ViewModel


}