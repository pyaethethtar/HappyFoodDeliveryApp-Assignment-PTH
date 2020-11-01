package com.example.happyfooddelivery.mvp.presenters.impls

import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.CheckoutPresenter
import com.example.happyfooddelivery.mvp.views.CheckoutView

class CheckoutPresenterImpl : CheckoutPresenter, AbstractBasePresenter<CheckoutView>() {

    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady() {
        mView?.displayDeliveryAddress("123 York StBrooklyn, NY 11201, USA")
    }

    override fun onTapConfirm() {
        mView?.displayBottomSheet()
        mFoodDeliveryModel.clearCart()
    }

    override fun onTapCancel() {

    }
}