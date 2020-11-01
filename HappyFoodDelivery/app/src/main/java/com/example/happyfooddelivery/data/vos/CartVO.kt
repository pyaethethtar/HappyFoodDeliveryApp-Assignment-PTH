package com.example.happyfooddelivery.data.vos

import com.google.firebase.database.PropertyName

data class CartVO (
    @get:PropertyName("item_id") @set:PropertyName("item_id") var itemId : Int = 0,
    @get:PropertyName("item_name") @set:PropertyName("item_name") var itemName : String = "",
    var price : Int = 0,
    var amount : Int = 0
)