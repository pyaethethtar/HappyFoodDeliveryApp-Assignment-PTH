package com.example.happyfooddelivery.mvp.views

interface CheckoutView : BaseView {


    fun displayDeliveryAddress(address : String)
    fun displayBottomSheet()
}