package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.data.vos.RestaurantVO
import kotlinx.android.synthetic.main.item_new_restaurant.view.*

class NewRestaurantViewHolder(itemView: View) : BaseViewHolder<RestaurantVO>(itemView) {

    override fun bindData(data: RestaurantVO) {
        Glide.with(itemView.context).load(data.image).into(itemView.ivRestaurant)
        itemView.tvRestaurantName.text = data.name
        itemView.tvRating.text = data.rating
        itemView.tvDescription.text = data.description
    }
}