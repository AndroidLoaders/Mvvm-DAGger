package com.example.mvvm_dagger.ui.auth

import android.os.Bundle
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.datamanager.DataManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private val TAG: String = "TAG --- ${AuthActivity::class.java.simpleName} --->"

    @Inject
    internal lateinit var dataManager: DataManager

    @Inject
    internal lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        btnAuthenticate.setOnClickListener {
            val userId: String = etUseId.text.toString()
            if (userId.isNotEmpty() && (userId != "0"))
                viewModel.authenticateUserWithId(userId.toInt())
        }
    }
}