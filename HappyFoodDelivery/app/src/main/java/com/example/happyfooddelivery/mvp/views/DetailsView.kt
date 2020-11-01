package com.example.happyfooddelivery.mvp.views

import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.data.vos.RestaurantVO

interface DetailsView : BaseView {

    fun displayRestaurantInfo(info : RestaurantVO)
    fun displayPopularFoods(foods : List<FoodVO>)
    fun displayMenuItems(items : List<FoodVO>)
    fun addItemCount()
    fun goToCart()
}