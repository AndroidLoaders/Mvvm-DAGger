package com.example.mvvm_dagger.di.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    fun provideApiClient(): Retrofit = Retrofit.Builder().baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}