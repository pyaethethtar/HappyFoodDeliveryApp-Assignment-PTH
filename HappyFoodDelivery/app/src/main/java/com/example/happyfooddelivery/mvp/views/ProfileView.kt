package com.example.happyfooddelivery.mvp.views

import android.graphics.Bitmap
import com.example.happyfooddelivery.data.vos.UserVO

interface ProfileView : BaseView {

    fun displayProfileData(user : UserVO)
    fun openGallery()
    fun navigateToHomeScreen()

}