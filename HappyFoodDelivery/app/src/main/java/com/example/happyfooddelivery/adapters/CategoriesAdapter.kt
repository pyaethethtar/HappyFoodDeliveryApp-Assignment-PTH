package com.example.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.data.vos.CategoryVO
import com.example.happyfooddelivery.view.viewholders.BaseViewHolder
import com.example.happyfooddelivery.view.viewholders.CategoryViewHolder

class CategoriesAdapter : BaseAdapter<BaseViewHolder<CategoryVO>, CategoryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CategoryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

}