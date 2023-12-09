package com.example.tugasandroid2.BottomNav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tugasandroid2.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var BottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNav = findViewById(R.id.bottomNavigationView)

        BottomNav.setOnItemSelectedListener { menuItem ->
        when(menuItem.itemId){
            R.id.Home-> {
                ReplaceFragment(HomeFragment())
                true
            }
            R.id.Diskusi-> {
                ReplaceFragment(Diskusi())
                true
            }
            R.id.Dokter-> {
                ReplaceFragment(KonsulFragment())
                true
            }
            R.id.profile-> {
                ReplaceFragment(ProfileFragment())
                true
            }
            else -> false
            }
        }
        ReplaceFragment(HomeFragment())

    }
    private fun ReplaceFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.FrameBottom, fragment).commit()
    }
}