package com.example.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.mvp.presenters.DetailsPresenter
import com.example.happyfooddelivery.view.viewholders.BaseViewHolder
import com.example.happyfooddelivery.view.viewholders.FoodViewHolder

class FoodAdapter(private val mPresenter : DetailsPresenter) : BaseAdapter<BaseViewHolder<FoodVO>, FoodVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FoodVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view, mPresenter)
    }


}