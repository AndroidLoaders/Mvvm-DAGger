package com.example.mvvm_dagger.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.networkadapter.SessionManager
import com.example.mvvm_dagger.ui.base.BaseActivity
import com.example.mvvm_dagger.ui.main.posts.PostsFragment
import com.example.mvvm_dagger.ui.main.profile.ProfileFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, PostsFragment(), PostsFragment.Tag)
            .commit()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

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
}
