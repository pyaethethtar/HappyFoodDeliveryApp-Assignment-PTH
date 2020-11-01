package com.example.happyfooddelivery.mvp.views

import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.data.vos.RestaurantVO

interface HomeView2 : BaseView {

    fun displayPopularChoices(items : List<FoodVO>)
    fun displayNewRestaurants(restaurants : List<RestaurantVO>)
}