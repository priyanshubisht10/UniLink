package com.example.unilink


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.prog_o_thonproject.fragments.HomeStudent
import com.example.unilink.databinding.ActivityLoginBinding
import com.example.unilink.databinding.ActivityLoginFragmentsHolderBinding
import com.example.unilink.fragments.StudentLogin
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.loginAsStudent.setOnClickListener {

            val intent = Intent(this,LoginFragmentsHolderActivity::class.java)
            intent.putExtra("fragmentToLoad", "FragmentA")
            startActivity(intent)
        }
        binding.loginAsAmbassador.setOnClickListener {

            val intent= Intent(this,LoginFragmentsHolderActivity::class.java)
            intent.putExtra("fragmentToLoad", "FragmentB")
            startActivity(intent)
        }

        binding.buttonRegister.setOnClickListener {
            val intent= Intent(this,LoginFragmentsHolderActivity::class.java)
            intent.putExtra("fragmentToLoad","FragmentC")
            startActivity(intent)

        }


    }


}