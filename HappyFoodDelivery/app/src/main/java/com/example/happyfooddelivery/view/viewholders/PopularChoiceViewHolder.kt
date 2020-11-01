package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.data.vos.RestaurantVO
import kotlinx.android.synthetic.main.item_popular_choice.view.*

class PopularChoiceViewHolder(itemView: View) : BaseViewHolder<FoodVO>(itemView) {

    override fun bindData(data: FoodVO) {
        Glide.with(itemView.context).load(data.foodImage).into(itemView.ivPopularChoice)
        itemView.tvFoodName.text = data.foodName
        itemView.tvRating.text = data.price.toString()
        itemView.tvDescription.text = data.duration
    }
}