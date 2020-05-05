package com.example.mvvm_dagger.ui.auth

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.viewmodelproviderfactory.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    companion object {
        val TAG: String = "TAG --- ${AuthActivity::class.java.simpleName} --->"
    }

    @Inject
    internal lateinit var factory: ViewModelProviderFactory

    @Inject
    internal lateinit var dataManager: DataManager

    private val viewModel: AuthViewModel by lazy {
        ViewModelProvider(this, factory)[AuthViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*if (::dataManager.isInitialized) {
            Toast.makeText(this, "DataManager initialised", Toast.LENGTH_SHORT).show()
            println("$TAG ${dataManager.getAccessToken()}")
            dataManager.getLoginUserDetails().subscribe({
                println("$TAG ApiManager injected")
            }, {
                println("$TAG ${it.message}")
            })
        }*/
    }
}