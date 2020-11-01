package com.example.happyfooddelivery.mvp.views

interface MainView : BaseView {

    fun navigateToRestaurantsScreen(viewType : Int)
    fun navigateToProfileScreen(email : String)
}