package com.example.unilink


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.unilink.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private val duration = Toast.LENGTH_SHORT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()
        binding.register1.setOnClickListener {
            startActivity(Intent(this,CreateAccountActivity::class.java))
        }


        // Check if the user is already authenticated
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // User is already signed in, navigate to the main activity
            startActivity(Intent(this, StudentHomeActivity::class.java))
            finish()
        }

        binding.login.setOnClickListener{
            loginuser()
        }
    }

    private fun loginuser() {
        val email = binding.username.text.toString()
        val password = binding.password.text.toString()


        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->


                if (task.isSuccessful && email.contains("campusambassador", ignoreCase = true)) {
                    val intent = Intent(this, AmbassadorHomeActivity::class.java)
                    startActivity(intent)
                    finish()
                    // Login success
                    auth.currentUser
                }else if (task.isSuccessful){
                    val intent= Intent(this,StudentHomeActivity::class.java)
                    startActivity(intent)
                }

                else
                {
                    val toast = Toast.makeText(this@LoginActivity, "Login Failed",duration)
                    toast.show()
                    // Login failed
                }
            }
        }
    }
}