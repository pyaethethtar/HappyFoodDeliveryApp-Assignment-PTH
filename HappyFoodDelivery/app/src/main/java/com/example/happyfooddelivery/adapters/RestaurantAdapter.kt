package com.example.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.delegates.RestaurantItemDelegate
import com.example.happyfooddelivery.view.viewholders.BaseViewHolder
import com.example.happyfooddelivery.view.viewholders.RestaurantViewHolder

class RestaurantAdapter(private val isNew : Boolean, private val mDelegate : RestaurantItemDelegate) : BaseAdapter<BaseViewHolder<RestaurantVO>, RestaurantVO>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RestaurantVO> {

        val view = if (isNew==true)    LayoutInflater.from(parent.context).inflate(R.layout.item_new_restaurant, parent, false)
            else    LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)

        return RestaurantViewHolder(view, mDelegate)
    }

}