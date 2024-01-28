package com.example.kalmy

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalmy.databinding.ContactCardViewBinding

class ContactViewAdapter (private val contactList : List<ContactView>): RecyclerView.Adapter<ContactViewAdapter.myViewHolder>(){

    var onContactClickListener : OnContactClickListener?=null

    public fun interface OnContactClickListener{
        fun onClick(name: String, number: String, position: Int)
    }
    class myViewHolder(var binding: ContactCardViewBinding) : RecyclerView.ViewHolder(binding.root){
        val name : TextView = binding.contactName
        val number : TextView = binding.contactNumber
        val ContacImage : ImageView = binding.contactImg
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var contact = contactList[position]
        holder.binding.contactName.text = contact.name
        holder.binding.contactNumber.text = contact.number
        holder.binding.contactImg.setImageResource(contact.contactImage)
        onContactClickListener?.let { listener->
            holder.itemView.setOnClickListener {
                listener.onClick(contact.name,contact.number,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var ContactItem = ContactCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return myViewHolder(ContactItem)
    }

    override fun getItemCount(): Int = contactList.size
}