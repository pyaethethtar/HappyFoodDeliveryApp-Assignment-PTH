package com.example.happyfooddelivery.mvp.views

import com.example.happyfooddelivery.data.vos.RestaurantVO

interface HomeView1 : BaseView {

    fun displayRestaurants(restaurants: List<RestaurantVO>)
    fun navigateToDetailsView(id : Int)
}