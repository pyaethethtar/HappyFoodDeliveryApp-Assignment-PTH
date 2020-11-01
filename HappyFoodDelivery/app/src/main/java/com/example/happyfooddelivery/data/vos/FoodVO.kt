package com.example.happyfooddelivery.data.vos

import android.icu.util.CurrencyAmount
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName

@IgnoreExtraProperties
data class FoodVO (
    @get:PropertyName("item_id") @set:PropertyName("item_id") var foodId : Int = 0,
    @get:PropertyName("item_name") @set:PropertyName("item_name") var foodName : String = "",
    @get:PropertyName("item_image") @set:PropertyName("item_image") var foodImage : String = "",
    var price : Int = 0,
    var duration : String ?= "",
    var ingredients : String ?= "",
    @get:PropertyName("is_popular") @set:PropertyName("is_popular") var isPopular : Boolean = true,
    var amount: Int ?= 0,
    var description : String ?= "",
    var rating : String ?= ""
)