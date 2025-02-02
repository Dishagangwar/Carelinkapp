package com.example.carelinkapp

import android.os.Bundle
import android.webkit.WebView.FindListener
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carelinkapp.databinding.ActivityFormsDonatedBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.DateFormat
import java.util.Calendar

class FormsDonated : AppCompatActivity() {
    private lateinit var donationBinding: ActivityFormsDonatedBinding
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myReference: DatabaseReference = database.reference.child("MyUsers")
    private val userList: ArrayList<Users> = ArrayList()
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding
        donationBinding = ActivityFormsDonatedBinding.inflate(layoutInflater)
        setContentView(donationBinding.root)

        // Initialize RecyclerView and adapter
        donationBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        donationBinding.recyclerView.setHasFixedSize(true)
        usersAdapter = UsersAdapter(this, userList)
        donationBinding.recyclerView.adapter = usersAdapter

        // Retrieve data from Firebase
        retrieveData()
    }

    private fun retrieveData() {

        myReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Clear userList to avoid duplicates
                userList.clear()

                for (eachUser in snapshot.children) {
                    val user = eachUser.getValue(Users::class.java)
                    if (user != null) {
                        userList.add(user)
                    }
                }

                // Notify adapter of data changes
                usersAdapter.notifyDataSetChanged()
                val calendar = Calendar.getInstance().time
                val dateFormat = DateFormat.getInstance().format(calendar)
                val dateTextView = findViewById<TextView>(R.id.txtDate)
                dateTextView.text= dateFormat
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@FormsDonated, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
