package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.mvp.views.MyOrderView

interface MyOrderPresenter : BasePresenter<MyOrderView> {

    fun onUiReady(restaurantId : Int)
    fun onTapCheckout()
    fun onTapAddMordFoods()
}