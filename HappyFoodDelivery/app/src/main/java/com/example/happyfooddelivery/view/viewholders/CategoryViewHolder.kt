package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.data.vos.CategoryVO
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryViewHolder(itemView: View) : BaseViewHolder<CategoryVO>(itemView) {

    override fun bindData(data: CategoryVO) {
        Glide.with(itemView.context).load(data.image).into(itemView.ivCategory)
        itemView.tvCategoryName.text = data.name
    }
}