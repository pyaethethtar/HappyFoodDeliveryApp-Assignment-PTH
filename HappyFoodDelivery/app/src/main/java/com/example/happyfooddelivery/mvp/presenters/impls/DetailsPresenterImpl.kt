package com.example.happyfooddelivery.mvp.presenters.impls

import com.example.happyfooddelivery.data.model.FoodDeliveryModel
import com.example.happyfooddelivery.data.model.FoodDeliveryModelImpl
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.mvp.presenters.DetailsPresenter
import com.example.happyfooddelivery.mvp.views.DetailsView

class DetailsPresenterImpl : DetailsPresenter, AbstractBasePresenter<DetailsView>() {

    private val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl
    private var mRestaurantId : Int = 0

    override fun onUiReady(id: Int) {
        mFoodDeliveryModel.getRestaurantById(id, onSuccess = {
            mView?.displayRestaurantInfo(it)
            mView?.displayMenuItems(it.foods)

            var itemList : ArrayList<FoodVO> = arrayListOf()
            for (item in it.foods){
                if (item.isPopular==true){
                    itemList.add(item)
                }
            }
            mView?.displayPopularFoods(itemList)
        })

        mRestaurantId = id
    }

    override fun onTapAddToCart(item : FoodVO) {
        mFoodDeliveryModel.addToCart(item.foodId, item.foodName, item.price, 1)
        mView?.addItemCount()
    }

    override fun onTapGoToCart() {
        mView?.goToCart()
    }

}