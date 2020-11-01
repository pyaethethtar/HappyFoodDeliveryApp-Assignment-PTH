package com.example.happyfooddelivery.data.model

import android.graphics.Bitmap
import com.example.groceryapppth.network.remoteconfig.FirebaseRemoteConfigManager
import com.example.happyfooddelivery.data.vos.CartVO
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.data.vos.UserVO
import com.example.happyfooddelivery.network.FirebaseApi
import com.example.happyfooddelivery.network.RealtimeDatabaseImpl

object FoodDeliveryModelImpl : FoodDeliveryModel {

    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseImpl
    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getRestaurants(onSuccess, onFailure)
    }

    override fun getRestaurantById(id : Int, onSuccess: (RestaurantVO) -> Unit) {
        mFirebaseApi.getRestaurantById(id, onSuccess)
    }

    override fun getCartItems(onSuccess: (List<CartVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getCartItems(onSuccess, onFailure)
    }

    override fun addToCart(itemId: Int, itemName: String, price: Int, amount: Int) {
        mFirebaseApi.addToCart(itemId, itemName, price, amount)
    }

    override fun clearCart() {
        mFirebaseApi.clearCart()
    }

    override fun getCurrentUserInfo(
        email: String,
        onSuccess: (UserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getCurrentUserInfo(email, onSuccess, onFailure)
    }

    override fun updateUserInfo(
        username: String,
        email: String,
        password: String,
        phone: String,
        city: String,
        country: String,
        image: Bitmap?
    ) {
        mFirebaseApi.updateUserInfo(username, email, password, phone, city, country, image)
    }

    override fun addUser(
        username: String,
        email: String,
        password: String,
        phone: String,
        city: String?,
        country: String?,
        image: String?
    ) {
        mFirebaseApi.addUser(username, email, password, phone, city, country, image)
    }

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getViewTypeFromRemoteConfig(): Int {
        return mFirebaseRemoteConfigManager.getViewType()
    }
}