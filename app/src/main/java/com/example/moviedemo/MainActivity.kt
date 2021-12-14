package com.example.moviedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    lateinit var navControlar: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navControlar=navHostFragment.navController
        setupActionBarWithNavController(navControlar)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navControlar.navigateUp() || super.onSupportNavigateUp()
    }
}