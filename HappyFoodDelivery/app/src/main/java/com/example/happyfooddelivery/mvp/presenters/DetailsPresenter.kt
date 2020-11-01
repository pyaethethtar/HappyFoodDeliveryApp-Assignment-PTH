package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.mvp.views.DetailsView

interface DetailsPresenter : BasePresenter<DetailsView> {

    fun onUiReady(id : Int)
    fun onTapAddToCart(item : FoodVO)
    fun onTapGoToCart()
}