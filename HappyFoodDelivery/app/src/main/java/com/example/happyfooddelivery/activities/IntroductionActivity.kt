package com.example.happyfooddelivery.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.fragments.GetStartedFragment

class IntroductionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        supportFragmentManager.beginTransaction().replace(R.id.flContainer, GetStartedFragment()).commit()
    }


}