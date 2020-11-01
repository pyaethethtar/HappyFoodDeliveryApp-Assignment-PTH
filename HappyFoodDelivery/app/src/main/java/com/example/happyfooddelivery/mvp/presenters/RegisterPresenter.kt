package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.mvp.views.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {

    fun onTapSignUp(username : String, email : String, password : String, phone : String)
    fun onTapLogin()

}