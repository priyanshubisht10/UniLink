package com.example.unilink.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.unilink.LoginActivity
import com.example.unilink.R
import com.example.unilink.StudentHomeActivity
import com.example.unilink.databinding.FragmentRegisterBinding
import com.example.unilink.databinding.FragmentStudentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentRegisterBinding
    private val duration = Toast.LENGTH_SHORT


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)

        binding.buttonCreateAccount.setOnClickListener {
            createAccount()
        }
        return binding.root
    }

    private fun createAccount() {
        val username = binding.editTextUsername.text.toString()
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                // User account created successfully
                val userId = FirebaseAuth.getInstance().currentUser?.uid.toString()
                Toast.makeText(requireContext(), "SuccesfullMessage", Toast.LENGTH_SHORT).show()
                // Create a user data document in Firestore
                val userData = hashMapOf(
                    "username" to username,
                    "email" to email
                )

                userId.let {
                    FirebaseFirestore.getInstance().collection("users")
                        .document(userId)
                        .set(userData)
                        .addOnCompleteListener { innerTask ->
                            if (innerTask.isSuccessful) {
                                val intent = Intent(requireActivity(), LoginActivity::class.java)
                                startActivity(intent)
                            }
                        }
                }


            }.addOnFailureListener { e ->
                Log.d(e.message,"registeration error")
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
            }
    }
}