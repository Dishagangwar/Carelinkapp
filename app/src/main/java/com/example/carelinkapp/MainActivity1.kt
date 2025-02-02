package com.example.carelinkapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carelinkapp.databinding.ActivityMain1Binding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity1 : AppCompatActivity() {

    lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonDonate.setOnClickListener() {
            val intent = Intent(this, DonateForm::class.java)
            startActivity(intent)
        }
        binding.buttonFood.setOnClickListener() {
            val intent = Intent(this, DonateForm::class.java)
            startActivity(intent)
        }
        binding.myDonations.setOnClickListener(){
           val intent= Intent(this,FormsDonated::class.java)
            startActivity(intent)
        }
//        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,
//            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
//                TODO("Not yet implemented")
//            }
//        }).attachToRecyclerView(binding.)
//    }


    }
}