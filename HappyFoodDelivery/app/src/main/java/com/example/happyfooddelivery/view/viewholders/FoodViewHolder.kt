package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.mvp.presenters.DetailsPresenter
import kotlinx.android.synthetic.main.item_food.view.*

class FoodViewHolder(itemView: View, private val mPresenter : DetailsPresenter) : BaseViewHolder<FoodVO>(itemView) {

    override fun bindData(data: FoodVO) {
        Glide.with(itemView.context).load(data.foodImage).into(itemView.ivFood)
        itemView.tvFoodName.text = data.foodName
        itemView.tvPrice.text = "$${data.price}"

        itemView.btnAddToCart.setOnClickListener {
            mPresenter.onTapAddToCart(data)
        }
    }
}