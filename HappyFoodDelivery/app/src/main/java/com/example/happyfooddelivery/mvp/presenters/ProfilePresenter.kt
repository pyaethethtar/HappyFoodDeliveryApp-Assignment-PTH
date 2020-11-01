package com.example.happyfooddelivery.mvp.presenters

import android.graphics.Bitmap
import com.example.happyfooddelivery.mvp.views.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {

    fun onUiReady(email : String)
    fun onTapPhotoUpload()
    fun onTapSave(username : String, email: String, password: String, phone: String, city: String, country: String, image: Bitmap?)
    fun onTapCancel()

}