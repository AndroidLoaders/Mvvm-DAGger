package com.example.mvvm_dagger.di.modules.main

import androidx.lifecycle.ViewModel
import com.example.mvvm_dagger.di.annotations.ViewModelKey
import com.example.mvvm_dagger.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}