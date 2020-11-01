package com.example.happyfooddelivery.mvp.presenters.impls

import android.util.Log
import com.example.happyfooddelivery.data.model.AuthenticationModel
import com.example.happyfooddelivery.data.model.AuthenticationModelImpl
import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.LoginPresenter
import com.example.happyfooddelivery.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthModel : AuthenticationModel = AuthenticationModelImpl
    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady() {
        mFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mFoodDeliveryModel.fetchRemoteConfigs()
    }

    override fun onTapLogin(email: String, password: String) {
        mAuthModel.login(email, password, onSuccess = {
            mView?.navigateToHomeScreen()
        }, onFailure = {
            mView?.showError(it)
        })
    }

    override fun onTapSignUp() {
        mView?.navigateToRegisterScreen()
    }
}