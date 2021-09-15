package com.example.tourismapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tourismapp.R
import com.example.tourismapp.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread(){
            override fun run(){
                try {
                    sleep(4000)

                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

    }
}