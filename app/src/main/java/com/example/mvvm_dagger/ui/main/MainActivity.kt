package com.example.mvvm_dagger.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.ui.auth.AuthViewModel
import com.example.mvvm_dagger.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuLogout -> sessionManager.logoutUser()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    /*override fun getViewModelData(): AuthViewModel {
        TODO("Not yet implemented")
    }*/
}
