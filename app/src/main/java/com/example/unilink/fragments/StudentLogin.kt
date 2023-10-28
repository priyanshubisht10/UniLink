package com.example.unilink.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unilink.StudentHomeActivity
import com.example.unilink.databinding.FragmentStudentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class StudentLogin : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentStudentLoginBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStudentLoginBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.login.setOnClickListener {
            loginuser()
        }

    }

    private fun loginuser() {
        val email = binding.username.text.toString()
        val password = binding.password.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(requireActivity(), StudentHomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        // Handle login failure here, e.g., show an error message to the user.
                    }
                }
        } else {
            // Handle empty email or password fields, e.g., show a validation message.
        }
    }

}