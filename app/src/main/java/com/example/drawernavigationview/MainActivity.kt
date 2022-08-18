package com.example.drawernavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationView=findViewById(R.id.nav_view)
        drawerLayout=findViewById(R.id.drawer_lay)
        drawerToggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->Toast.makeText(this,"Home Clicked",Toast.LENGTH_SHORT).show()
                R.id.setting->Toast.makeText(this,"Setting Clicked",Toast.LENGTH_SHORT).show()
                R.id.call->Toast.makeText(this,"Call Clicked",Toast.LENGTH_SHORT).show()
                R.id.people->Toast.makeText(this,"People Clicked",Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }
}