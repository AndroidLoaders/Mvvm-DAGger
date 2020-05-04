package com.example.mvvm_dagger.ui.auth

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger.viewmodelproviderfactory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var factory: ViewModelProviderFactory

    private val viewModel: AuthViewModel by lazy {
        ViewModelProvider(this, factory)[AuthViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}