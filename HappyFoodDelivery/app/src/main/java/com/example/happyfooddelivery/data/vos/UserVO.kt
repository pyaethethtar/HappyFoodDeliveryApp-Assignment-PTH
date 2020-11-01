package com.example.happyfooddelivery.data.vos

data class UserVO (

    var username : String = "",
    var email : String = "",
    var password : String = "",
    var phone : String = "",
    var image : String ?= "",
    var city : String ?= "",
    var country : String ?= ""
)