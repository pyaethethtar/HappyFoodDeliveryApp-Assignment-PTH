package com.example.happyfooddelivery.mvp.presenters.impls

import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.MyOrderPresenter
import com.example.happyfooddelivery.mvp.views.MyOrderView

class MyOrderPresenterImpl : MyOrderPresenter, AbstractBasePresenter<MyOrderView>() {

    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(restaurantId: Int) {

        mFoodDeliveryModel.getRestaurantById(restaurantId, onSuccess = {
            mView?.displayRestaurantInfo(it)
        })
        mFoodDeliveryModel.getCartItems(onSuccess = {
            mView?.displayMyOrders(it)
        }, onFailure = {
            mView?.showError(it)
        })
    }

    override fun onTapCheckout() {
        mView?.navigateToCheckoutScreen()
    }

    override fun onTapAddMordFoods() {

    }
}