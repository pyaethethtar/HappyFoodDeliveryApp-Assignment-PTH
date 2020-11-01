package com.example.happyfooddelivery.data.model

import com.example.happyfooddelivery.network.auth.AuthManager

interface AuthenticationModel {

    var mAuthManager : AuthManager
    fun register(username : String, email: String, password: String, onSuccess: ()->Unit, onFailure: (String)->Unit)
    fun login(email: String, password: String, onSuccess: ()->Unit, onFailure: (String)->Unit)
    fun getEmail() : String
}