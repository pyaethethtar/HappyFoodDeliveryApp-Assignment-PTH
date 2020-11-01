package com.example.happyfooddelivery.network.auth

interface AuthManager {

    fun register(username : String, email: String, password: String, onSuccess: ()->Unit, onFailure: (String)->Unit)
    fun login(email: String, password: String, onSuccess: ()->Unit, onFailure: (String)->Unit)
    fun getEmail() : String
}