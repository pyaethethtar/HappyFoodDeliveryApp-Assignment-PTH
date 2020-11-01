package com.example.happyfooddelivery.mvp.presenters.impls

import com.example.happyfooddelivery.data.model.AuthenticationModel
import com.example.happyfooddelivery.data.model.AuthenticationModelImpl
import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.MainPresenter
import com.example.happyfooddelivery.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mAuthModel : AuthenticationModel = AuthenticationModelImpl
    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl
    private var mViewType : Int = 0

    override fun onUiReady() {
        mViewType = mFoodDeliveryModel.getViewTypeFromRemoteConfig()
        mView?.navigateToRestaurantsScreen(mViewType)
    }

    override fun onTapRestaurants() {
        mView?.navigateToRestaurantsScreen(mViewType)
    }

    override fun onTapAccount() {
        mView?.navigateToProfileScreen(mAuthModel.getEmail())
    }
}