package com.example.carelinkapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.carelinkapp.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {
    lateinit var binding: ActivityLoginPageBinding
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnUp.setOnClickListener() {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener() {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            signInFirebase(email,password)
//            val intent = Intent(this, MainActivity1::class.java)
//            startActivity(intent)
        }
//        binding.btnSignUp.setOnClickListener(){
//            val name = binding.etName.text.toString().trim()
//            val email= binding.etEmail.text.toString().trim()
//            val password = binding.etPassword.text.toString().trim()
//
//            Log.d("Email:",email)
//            Log.d("Pass:",password)
//
//            if (email.isEmpty() || password.isEmpty()) {
//                Toast.makeText(applicationContext, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }

        // signInFirebase(email,password)
    }


    fun signInFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful
                    Toast.makeText(applicationContext, "Login successful!", Toast.LENGTH_SHORT)
                        .show()
                    // Navigate to MainActivity1
                    val intent = Intent(this, MainActivity1::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Handle error case
                    val errorMessage = task.exception?.message ?: "Unknown error"
                    Toast.makeText(applicationContext, "Error: $errorMessage", Toast.LENGTH_LONG)
                        .show()
                    Log.d("Login", errorMessage.toString())
                }
            }
    }
    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user!=null){
            Toast.makeText(applicationContext,"Welcome to CareLink",Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LoginPage,MainActivity1::class.java)
            startActivity(intent)
            finish()
        }
    }
}

