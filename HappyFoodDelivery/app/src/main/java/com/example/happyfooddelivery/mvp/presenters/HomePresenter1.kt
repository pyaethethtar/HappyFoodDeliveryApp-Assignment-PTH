package com.example.happyfooddelivery.mvp.presenters

import com.example.happyfooddelivery.delegates.RestaurantItemDelegate
import com.example.happyfooddelivery.mvp.views.HomeView1

interface HomePresenter1 : BasePresenter<HomeView1>, RestaurantItemDelegate {

    fun onUiReady()
}