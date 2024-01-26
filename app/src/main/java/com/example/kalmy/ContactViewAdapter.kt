package com.example.kalmy

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalmy.databinding.ContactViewBinding

class ContactViewAdapter (private val contactList : List<ContactView>): RecyclerView.Adapter<ContactViewAdapter.myViewHolder>(){
    class myViewHolder(var binding: ContactViewBinding) : RecyclerView.ViewHolder(binding.root){
        val name : TextView = binding.contactName
        val number : TextView = binding.contactNumber
        val mail : TextView = binding.contactMail
        val ContacImage : ImageView = binding.contactImg
        val contactNumberImage : ImageView = binding.contactNumberImage
        val contactNameImage : ImageView = binding.contactImag
        val contactMailImage : ImageView = binding.contactMailImage
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var contact = contactList[position]
        holder.binding.contactName.text = contact.name
        holder.binding.contactNumber.text = contact.number
        holder.binding.contactMail.text = contact.mail
        holder.binding.contactImg.setImageResource(contact.contactImage)
        holder.binding.contactImag.setImageResource(contact.contactNameImg)
        holder.binding.contactNumberImage.setImageResource(contact.contactNumberImg)
        holder.binding.contactMailImage.setImageResource(contact.contactMailImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var ContactItem = ContactViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return myViewHolder(ContactItem)
    }

    override fun getItemCount(): Int = contactList.size
}