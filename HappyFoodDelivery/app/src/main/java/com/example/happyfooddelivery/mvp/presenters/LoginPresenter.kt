package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onUiReady()
    fun onTapLogin(email : String, password : String)
    fun onTapSignUp()
}