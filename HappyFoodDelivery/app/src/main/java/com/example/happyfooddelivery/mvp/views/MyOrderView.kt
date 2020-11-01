package com.example.happyfooddelivery.mvp.views

import com.example.happyfooddelivery.data.vos.CartVO
import com.example.happyfooddelivery.data.vos.RestaurantVO

interface MyOrderView : BaseView {

    fun displayRestaurantInfo(info : RestaurantVO)
    fun displayMyOrders(orders : List<CartVO>)
    fun navigateToCheckoutScreen()
}