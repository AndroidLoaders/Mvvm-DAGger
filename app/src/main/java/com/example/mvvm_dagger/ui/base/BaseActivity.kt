package com.example.mvvm_dagger.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvm_dagger.base.extensions.getTargetIntentAndFinish
import com.example.mvvm_dagger.networkadapter.SessionManager
import com.example.mvvm_dagger.networkadapter.api.response.ResponseStatus
import com.example.mvvm_dagger.ui.auth.AuthActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    private val TAG: String = "TAG --- ${BaseActivity::class.java.simpleName} --->"

    @Inject
    internal lateinit var sessionManager: SessionManager

    @Inject
    //internal lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        subscribeData()
    }

    abstract fun getLayoutId(): Int
    //abstract fun getViewModelData(): VM

    private fun subscribeData() {
        sessionManager.observeAuthUser().observe(this, Observer {
            println("$TAG $it")
            when (it.status) {
                ResponseStatus.Loading -> {
                }
                ResponseStatus.Success -> {
                }
                ResponseStatus.Error -> {
                    Toast.makeText(this, "Id must be within 1 to 10", Toast.LENGTH_SHORT).show()
                }
                ResponseStatus.NonAuthenticated -> getTargetIntentAndFinish(AuthActivity::class.java)
            }
        })
    }
}