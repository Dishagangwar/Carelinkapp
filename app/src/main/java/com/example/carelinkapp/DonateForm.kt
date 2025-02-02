package com.example.carelinkapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carelinkapp.databinding.ActivityDonateFormBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DonateForm : AppCompatActivity() {
    lateinit var binding: ActivityDonateFormBinding
    val database:FirebaseDatabase=FirebaseDatabase.getInstance()
    val myDatabaseReference:DatabaseReference=database.reference.child("MyUsers")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDonateFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnSubmit.setOnClickListener(){
            addUserToDataBase()
        }

    }
    fun addUserToDataBase(){
        val name:String=binding.ettName.text.toString()
        val contact:Long=binding.etContact.text.toString().toLong()
        val location:String=binding.etLocation.text.toString()
        val food: String= binding.etfood.text.toString()
        val quantity:String = binding.etquantity.text.toString()
        val note:String = binding.etNotes.text.toString()
        val id: String= myDatabaseReference.push().key.toString()

        val user= Users(id,name,contact,location,food,quantity,note)
        myDatabaseReference.child(id).setValue(user).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(applicationContext,"form submitted successfully ", Toast.LENGTH_SHORT).show()
                finish()
            }
            else{
                Toast.makeText(applicationContext,task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
