package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.mvp.views.CheckoutView

interface CheckoutPresenter : BasePresenter<CheckoutView> {

    fun onUiReady()
    fun onTapConfirm()
    fun onTapCancel()
}