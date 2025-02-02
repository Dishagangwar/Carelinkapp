package com.example.carelinkapp

import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.carelinkapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
          lateinit var signUpBinding: ActivitySignUpBinding
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding=ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)
        signUpBinding.btnSignUp.setOnClickListener {
            val name = signUpBinding.etName.text.toString()
            val email= signUpBinding.etEmail.text.toString()
            val password= signUpBinding.etPassword.text.toString()
            signUpWithFirebase(email,password)
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)

        }

    }
    fun signUpWithFirebase(userEmail:String, userPassword:String){
        auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnSuccessListener {
            Log.d("Successfulllyu", "whycuiiwuedhi")
            Toast.makeText(applicationContext, "You account has been created", Toast.LENGTH_SHORT)
                .show()
        }.addOnFailureListener(){ task->
                Toast.makeText(applicationContext,task.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}