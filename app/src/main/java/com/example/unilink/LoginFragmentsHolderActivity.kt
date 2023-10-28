package com.example.unilink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.unilink.R
import com.example.unilink.R.id.fragment2
import com.example.unilink.fragments.AmbassadorLogin
import com.example.unilink.fragments.PostFragment
import com.example.unilink.fragments.ProfileFragment
import com.example.unilink.fragments.RegisterFragment
import com.example.unilink.fragments.StudentLogin

class LoginFragmentsHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_fragments_holder)

        val fragmentToLoad = intent.getStringExtra("fragmentToLoad")

        // Load the appropriate fragment into the container
        when (fragmentToLoad) {
            "FragmentA" -> supportFragmentManager.beginTransaction()
                .replace(fragment2, StudentLogin())
                .commit()
            "FragmentB" -> supportFragmentManager.beginTransaction()
                .replace(fragment2, AmbassadorLogin())
                .commit()
            "FragmentC" -> supportFragmentManager.beginTransaction()
                .replace(fragment2, RegisterFragment())
                .commit()

        }

    }
}