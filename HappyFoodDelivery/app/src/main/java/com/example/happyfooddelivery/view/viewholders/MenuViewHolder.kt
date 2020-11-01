package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.mvp.presenters.DetailsPresenter
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuViewHolder(itemView: View, private val mPresenter : DetailsPresenter) : BaseViewHolder<FoodVO>(itemView) {

    override fun bindData(data: FoodVO) {
        itemView.tvBurgerName.text = data.foodName
        itemView.tvIngredients.text = data.ingredients
        itemView.tvBurgerPrice.text = "$${data.price}"
        if (data.isPopular==true){
            itemView.tvPopular.visibility = View.VISIBLE
        }
        else{
            itemView.tvPopular.visibility = View.GONE
        }

        itemView.btnAddToCart.setOnClickListener {
            mPresenter.onTapAddToCart(data)
        }
    }
}