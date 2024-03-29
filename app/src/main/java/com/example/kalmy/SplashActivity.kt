package com.example.kalmy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(mainLooper).postDelayed({
            startApp()
        },1500)
    }
    private fun startApp(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}