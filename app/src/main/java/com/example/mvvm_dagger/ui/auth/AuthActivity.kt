package com.example.mvvm_dagger.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.base.extensions.getTargetIntentAndFinish
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.networkadapter.api.response.ResponseStatus
import com.example.mvvm_dagger.ui.main.MainActivity
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

        subscribeStream()

        btnAuthenticate.setOnClickListener {
            val userId: String = etUserId.text.toString()
            if (userId.isNotEmpty() && (userId != "0"))
                viewModel.authenticateUserWithId(userId.toInt())
        }
    }

    private fun subscribeStream() {
        viewModel.observeAuthUser().observe(this, Observer {
            println("$TAG $it")
            when (it.status) {
                ResponseStatus.Loading -> progress(View.VISIBLE)
                ResponseStatus.Success -> {
                    progress(View.GONE)
                    getTargetIntentAndFinish(MainActivity::class.java)
                }
                ResponseStatus.Error -> {
                    progress(View.GONE)
                    Toast.makeText(this, "Id must be within 1 to 10", Toast.LENGTH_SHORT).show()
                }
                ResponseStatus.NonAuthenticated -> progress(View.GONE)
            }
        })
    }

    private fun progress(isVisible: Int) {
        progressBar.visibility = isVisible
    }
}