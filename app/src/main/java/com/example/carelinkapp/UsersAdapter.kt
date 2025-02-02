package com.example.carelinkapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carelinkapp.databinding.UserItemBinding

class UsersAdapter  (var context: Context,
                     var userList:ArrayList<Users>): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    inner class UsersViewHolder(val adapterBinding: UserItemBinding)
        : RecyclerView.ViewHolder(adapterBinding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UsersViewHolder {
        val binding= UserItemBinding.inflate(LayoutInflater.from(p0.context),p0,false)
        return  UsersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.adapterBinding.userName.text=userList[position].userName
        holder.adapterBinding.userContact.text=userList[position].userContact.toString()
        holder.adapterBinding.userLocation.text=userList[position].userLocation
        holder.adapterBinding.userFood.text=userList[position].userFood
        holder.adapterBinding.userQuantity.text=userList[position].userQuantity
        holder.adapterBinding.userNotes.text=userList[position].userNote
    }
    }

