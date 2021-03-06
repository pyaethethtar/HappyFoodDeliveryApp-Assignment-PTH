package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.delegates.RestaurantItemDelegate
import kotlinx.android.synthetic.main.item_restaurant.view.*
import kotlinx.android.synthetic.main.item_new_restaurant.view.*

class RestaurantViewHolder(itemView: View, private val mDelegate: RestaurantItemDelegate) : BaseViewHolder<RestaurantVO>(itemView) {
    

    override fun bindData(data: RestaurantVO) {
        itemView.ivRestaurant?.let {
            Glide.with(itemView.context).load(data.image).into(itemView.ivRestaurant)
            itemView.tvRestaurantName.text = data.name
            itemView.tvRating.text = data.rating
            itemView.tvDescription.text = data.description
        }

        itemView.ivNewRestaurant?.let {
            Glide.with(itemView.context).load(data.image).into(itemView.ivNewRestaurant)
            itemView.tvNewRestaurantName.text = data.name
            itemView.tvNewRating.text = data.rating
            itemView.tvNewDescription.text = data.description
        }


        itemView.setOnClickListener {
            mDelegate.onTapRestaurant(data.id)
        }
    }
}