package com.example.mvvm_dagger.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.ui.base.BaseActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuLogout -> sessionManager.logoutUser()
            android.R.id.home ->
                return if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                } else false
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onSupportNavigateUp(): Boolean =
        NavigationUI.navigateUp(navController, drawerLayout)

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuProfile -> {
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.mainNavigation, true)
                    .build()

                navController.navigate(R.id.navigationProfile, null, navOptions)
            }
            R.id.menuPosts -> if (isValidDestination(R.id.navigationPosts)) {
                navController.navigate(R.id.navigationPosts)
            }
        }

        item.isChecked = true
        drawerLayout.closeDrawer(GravityCompat.START, true)
        return true
    }

    private fun initViews() {
        navController = findNavController(R.id.navHostContainer)
        setupActionBarWithNavController(navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun isValidDestination(destinationId: Int): Boolean =
        (destinationId != navController.currentDestination!!.id)
}
