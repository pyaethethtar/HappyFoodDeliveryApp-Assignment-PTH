package com.example.happyfooddelivery.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.happyfooddelivery.mvp.views.BaseView
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(), BaseView {


    override fun showError(error: String) {
        Snackbar.make(window.decorView, error, Snackbar.LENGTH_LONG).show()
    }
}