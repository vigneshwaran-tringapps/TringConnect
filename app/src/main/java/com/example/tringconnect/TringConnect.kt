package com.example.tringconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tringconnect.adapters.PostAdapter
import com.example.tringconnect.models.blogPost
import com.google.android.material.bottomnavigation.BottomNavigationView

class TringConnect : AppCompatActivity() {
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navHostFragment =
          supportFragmentManager.findFragmentById(R.id.postNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView =  findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(bottomNavigationView,navController)



    }

}