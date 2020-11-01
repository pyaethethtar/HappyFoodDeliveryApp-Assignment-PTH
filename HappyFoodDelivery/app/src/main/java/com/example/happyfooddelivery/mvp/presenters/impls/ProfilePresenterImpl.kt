package com.example.happyfooddelivery.mvp.presenters.impls

import android.graphics.Bitmap
import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.mvp.presenters.ProfilePresenter
import com.example.happyfooddelivery.mvp.views.ProfileView

class ProfilePresenterImpl : ProfilePresenter, AbstractBasePresenter<ProfileView>() {

    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(email: String) {
        mFoodDeliveryModel.getCurrentUserInfo(email, onSuccess = {
            mView?.displayProfileData(it)
        }, onFailure = {
            mView?.showError(it)
        })
    }

    override fun onTapPhotoUpload() {
        mView?.openGallery()
    }

    override fun onTapSave(
        username : String,
        email: String,
        password: String,
        phone: String,
        city: String,
        country: String,
        image: Bitmap?
    ) {
        mFoodDeliveryModel.updateUserInfo(username, email, password, phone, city, country, image)

        mView?.navigateToHomeScreen()
    }

    override fun onTapCancel() {
        mView?.navigateToHomeScreen()
    }
}