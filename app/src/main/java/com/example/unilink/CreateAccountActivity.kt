package com.example.unilink


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.unilink.databinding.ActivityCreateAccountBinding

import com.google.firebase.auth.FirebaseAuth


class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private val duration = Toast.LENGTH_SHORT
    private lateinit var createAccountInputsArray: Array<EditText>
    private lateinit var userId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)


        createAccountInputsArray = arrayOf(binding.email, binding.password)
        binding.register.setOnClickListener {
            signIn()
        }


    }

    private fun signIn() {

        userEmail = binding.email.text.toString().trim()
        userPassword = binding.password.text.toString().trim()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val toast = Toast.makeText(
                        this@CreateAccountActivity,
                        "Account Created Successfully",
                        duration
                    )
                    toast.show()
                    sendEmailVerification()
                    userId = FirebaseAuth.getInstance().currentUser?.uid.toString()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    val toast = Toast.makeText(
                        this@CreateAccountActivity,
                        "Failed to Authenticate",
                        duration
                    )
                    toast.show()
                }
            }
    }


    private fun sendEmailVerification() {
        TODO("Not yet implemented")
    }
}


