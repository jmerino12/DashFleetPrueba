package com.jmb.dashfleetprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jmb.dashfleetprueba.databinding.ActivityMainBinding
import com.jmb.dashfleetprueba.menu.DashBoardragment
import kotlinx.coroutines.Dispatchers.Main
import java.sql.SQLOutput

class MainActivity : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener  {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navController = findNavController(R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)
        binding.navigationView.setupWithNavController(navController);

        setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        binding.navigationView.setNavigationItemSelectedListener(this)
        binding.navigationView.bringToFront()
        binding.navigationView.setCheckedItem(R.id.inicio)
        binding.menuIcon.setOnClickListener {
            if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.END)
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dashboard -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, DashBoardragment.newInstance())
                    .commit()
            }
        }
        return true
    }


    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

        }
    }

}