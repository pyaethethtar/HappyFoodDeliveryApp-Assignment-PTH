package com.example.happyfooddelivery.mvp.presenters.impls

import android.util.Log
import com.example.happyfooddelivery.data.model.AuthenticationModel
import com.example.happyfooddelivery.data.model.AuthenticationModelImpl
import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.RegisterPresenter
import com.example.happyfooddelivery.mvp.views.RegisterView

class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthModel : AuthenticationModel = AuthenticationModelImpl
    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onTapSignUp(username: String, email: String, password: String, phone: String) {
        mAuthModel.register(username, email, password, onSuccess = {
            mView?.navigateToLoginScreen()
        }, onFailure = {
            mView?.showError(it)
        })

        mFoodDeliveryModel.addUser(username, email, password, phone, "", "", "")
    }

    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }
}