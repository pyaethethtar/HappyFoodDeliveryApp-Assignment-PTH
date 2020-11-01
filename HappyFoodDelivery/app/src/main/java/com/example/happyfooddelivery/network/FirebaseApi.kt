package com.example.happyfooddelivery.network

import android.graphics.Bitmap
import com.example.happyfooddelivery.data.vos.CartVO
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.data.vos.UserVO

interface FirebaseApi {

    fun getRestaurants(onSuccess:(List<RestaurantVO>)->Unit, onFailure:(String)->Unit)
    fun getRestaurantById(id: Int, onSuccess: (RestaurantVO) -> Unit)
    fun getCartItems(onSuccess: (List<CartVO>)-> Unit, onFailure: (String) -> Unit)
    fun addToCart(itemId: Int, itemName: String, price: Int, amount: Int)
    fun getCurrentUserInfo(email : String, onSuccess: (UserVO) -> Unit, onFailure: (String) -> Unit)
    fun updateUserInfo(username: String, email: String, password: String, phone: String, city: String, country: String, image: Bitmap?)
    fun addUser(username: String, email: String, password: String, phone: String, city: String?, country: String?, image: String?)
    fun clearCart()
}