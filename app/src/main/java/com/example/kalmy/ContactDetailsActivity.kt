package com.example.kalmy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kalmy.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityContactDetailsBinding
    lateinit var name : String
    lateinit var number: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        name = intent.getStringExtra(const.Name)?:""
        number = intent.getStringExtra(const.Number)?:""
        initView()
    }

    private fun initView() {
        viewBinding.nameTv.text = name
        viewBinding.numberInt.text = number
    }
}