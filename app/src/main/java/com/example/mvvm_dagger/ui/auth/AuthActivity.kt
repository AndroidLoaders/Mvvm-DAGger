package com.example.mvvm_dagger.ui.auth

import android.os.Bundle
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.base.extensions.rx.autoDispose
import com.example.mvvm_dagger.datamanager.DataManager
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private val TAG: String = "TAG --- ${AuthActivity::class.java.simpleName} --->"

    @Inject
    internal lateinit var dataManager: DataManager

    @Inject
    internal lateinit var viewModel: AuthViewModel

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel.observeLoadingData().subscribe {
            btnAuthenticate.isClickable = !it
        }.autoDispose(disposables)

        btnAuthenticate.setOnClickListener {
            val userId: String = etUseId.text.toString()
            if (userId.isNotEmpty() && (userId != "0"))
                viewModel.authenticateUserWithId(userId.toInt())
        }
    }

    override fun onDestroy() {
        if ((disposables.size() > 0) && !disposables.isDisposed) {
            try {
                disposables.dispose()
                disposables.clear()
            } catch (e: Exception) {
                println("$TAG ${e.message}")
            }
        }
        super.onDestroy()
    }
}