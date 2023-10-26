package com.example.unilink



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.unilink.fragments.PostFragment
import com.example.unilink.fragments.ProfileFragment
import com.example.unilink.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AmbassadorHomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambassador_home)



        bottomNavigationView = findViewById(R.id.nav_view)

        supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment()).commit()

        bottomNavigationView.setOnItemSelectedListener {
            var fragment: Fragment? = null

            when (it.itemId) {
                R.id.nav_home -> {
                    fragment = ProfileFragment()
                }


                R.id.nav_search -> {
                    fragment = SearchFragment()
                }

                R.id.nav_favorites -> {
                    fragment = PostFragment()
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.container,fragment!!).commit()
            return@setOnItemSelectedListener true

        }


    }



}