package com.example.carelinkapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.carelinkapp.databinding.ActivityStartpageBinding

class StartPage: AppCompatActivity() {
    lateinit var binding: ActivityStartpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityStartpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.startButton.setOnClickListener(){
            startActivity(Intent(this, LoginPage::class.java))
        }

    }
}