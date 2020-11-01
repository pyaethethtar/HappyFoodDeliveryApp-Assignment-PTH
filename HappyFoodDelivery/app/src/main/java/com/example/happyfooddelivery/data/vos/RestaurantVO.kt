package com.example.happyfooddelivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class RestaurantVO (
    var id : Int = 0,
    var name : String = "",
    var image : String = "",
    var description : String ?= "",
    var rating : String ?= "",
    var location : String ?= "",
    var foods : ArrayList<FoodVO> = arrayListOf()
)