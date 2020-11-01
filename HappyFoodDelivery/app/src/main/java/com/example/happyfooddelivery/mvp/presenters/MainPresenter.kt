package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun onUiReady()
    fun onTapRestaurants()
    fun onTapAccount()
}