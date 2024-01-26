package com.example.kalmy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.kalmy.databinding.ActivityMainBinding
import com.example.kalmy.ContactViewAdapter as ContactViewAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var adapter : ContactViewAdapter
    var contacList:MutableList<ContactView> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecView()
        putInRecycleView()
    }

    private fun initRecView() {
        adapter = ContactViewAdapter(contacList)
        binding.recViewContact.adapter = adapter
    }

    private fun putInRecycleView() {
        binding.contact.btnSave.setOnClickListener {
            if (!textValidate()) {
                return@setOnClickListener
            }
            val name = binding.contact.Nameedt.text?.trim().toString()
            val number = binding.contact.Numberedt.text?.trim().toString()
            val mail = binding.contact.Mailedt.text?.trim().toString()
            val Contact: ContactView = ContactView(
                name = name,
                number = number,
                contactImage = R.drawable.contactimg,
                contactNameImg = R.drawable.contact,
                contactNumberImg = R.drawable.phonecall,
                contactMailImg = R.drawable.email,
                mail = mail
            )
            contacList.add(Contact)
            adapter.notifyItemInserted(contacList.size - 1)

        }
    }

    fun textValidate() : Boolean{
        val name  = binding.contact.Nameedt.text?.trim().toString()
        val number = binding.contact.Numberedt.text?.trim().toString()
        binding.contact.nameTextField.error = validateName(name)
        binding.contact.numberTextField.error = validateNumber(number)
        return validateName(name) == null && validateNumber(number) == null

    }
    fun validateName(name: String) : String?{
        if(name.isEmpty())
            return "Enter name"
        if(name.trim().length < 3)
            return "please enter name with length more than 3"
        return null
    }
    fun validateNumber(number : String):String?{
        if(number.isEmpty())
            return "Enter number"
        if(number.trim().length != 11)
            return "please Enter valid number with 11 numbers"
        return null
    }
}