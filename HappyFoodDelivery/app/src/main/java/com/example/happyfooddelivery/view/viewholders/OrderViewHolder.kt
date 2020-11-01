package com.example.happyfooddelivery.view.viewholders

import android.view.View
import com.example.happyfooddelivery.data.vos.CartVO
import kotlinx.android.synthetic.main.item_orders.view.*

class OrderViewHolder(itemView: View) : BaseViewHolder<CartVO>(itemView) {


    override fun bindData(data: CartVO) {
        itemView.tvItemName.text = "${data.itemName} x${data.amount}"
        itemView.tvItemPrice.text = "$${data.price}"
    }
}