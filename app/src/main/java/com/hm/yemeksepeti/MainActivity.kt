package com.hm.yemeksepeti

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hm.yemeksepeti.databinding.ActivityMainBinding
import com.hm.yemeksepeti.entities.Yemekler


class MainActivity : AppCompatActivity() {

    val sepet_array = arrayListOf<Yemekler>()

    private lateinit var tasarim: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(tasarim.bottomNav, navHostFragment.navController)

        setSupportActionBar(tasarim.toolbar)
        setupActionBarWithNavController(navHostFragment.navController)
        tasarim.toolbar.setupWithNavController(navHostFragment.navController)

    }
    fun getMyTextView(): TextView = tasarim.toolbarTitle

    fun getArray():ArrayList<Yemekler> = sepet_array

}