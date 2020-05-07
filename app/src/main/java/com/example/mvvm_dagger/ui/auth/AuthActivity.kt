package com.example.mvvm_dagger.ui.auth

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.base.extensions.getTargetIntent
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.ui.MainActivity
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

        viewModel.observeUser().observe(this, Observer {
            it?.let {
                startActivity(getTargetIntent(MainActivity::class.java))
                finish()
            }
        })

        btnAuthenticate.setOnClickListener {
            val userId: String = etUseId.text.toString()
            if (userId.isNotEmpty() && (userId != "0"))
                viewModel.authenticateUserWithId(userId.toInt())
        }
    }
}