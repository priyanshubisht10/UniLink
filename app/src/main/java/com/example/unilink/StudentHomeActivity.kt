package com.example.unilink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.prog_o_thonproject.fragments.HomeStudent
import com.example.unilink.fragments.ChatRoom
import com.example.unilink.fragments.ProfileStudent

import com.google.android.material.bottomnavigation.BottomNavigationView

class StudentHomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)

        bottomNavigationView = findViewById(R.id.nav_view2)

        supportFragmentManager.beginTransaction().replace(R.id.container2, HomeStudent()).commit()

        bottomNavigationView.setOnItemSelectedListener {
            var fragment: Fragment? = null

            when (it.itemId) {
                R.id.nav_home_student -> {
                    fragment = HomeStudent()
                }

                R.id.nav_message_student -> {
                    fragment = ChatRoom()
                }

                R.id.nav_profile_student -> {
                    fragment = ProfileStudent()
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.container2,fragment!!).commit()
            return@setOnItemSelectedListener true

        }
    }
}