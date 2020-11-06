package com.example.happyfooddelivery.mvp.presenters.impls

import android.util.Log
import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.HomePresenter1
import com.example.happyfooddelivery.mvp.views.HomeView1

class HomePresenter1Impl : AbstractBasePresenter<HomeView1>(), HomePresenter1 {

    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady() {
        mFoodDeliveryModel.getCategories({
            mView?.displayCategories(it)
        },{
            mView?.showError(it)
        })

        mFoodDeliveryModel.getRestaurants({
            mView?.displayRestaurants(it)
        },{
            mView?.showError(it)
        })
    }

    override fun onTapRestaurant(id: Int) {
        mView?.navigateToDetailsView(id)
    }
}