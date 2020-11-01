package com.example.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.adapters.OrdersAdapter
import com.example.happyfooddelivery.data.vos.CartVO
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.mvp.presenters.MyOrderPresenter
import com.example.happyfooddelivery.mvp.presenters.impls.MyOrderPresenterImpl
import com.example.happyfooddelivery.mvp.views.MyOrderView
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : BaseActivity(), MyOrderView {

    private var restaurantId : Int = 1
    private lateinit var mPresenter : MyOrderPresenter
    private lateinit var mAdapter : OrdersAdapter

    companion object{
        const val RESTAURANT_ID_EXTRA = "RESTAURANT_ID_EXTRA"
        fun newIntent(context: Context, id: Int) : Intent{
            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra(RESTAURANT_ID_EXTRA, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        restaurantId = intent.getIntExtra(RESTAURANT_ID_EXTRA, 1)

        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(restaurantId)

        btnCheckout.setOnClickListener {
            mPresenter.onTapCheckout()
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MyOrderPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        rvOrders.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = OrdersAdapter()
        rvOrders.adapter = mAdapter
    }

    override fun displayMyOrders(orders: List<CartVO>) {
        mAdapter.setNewData(orders)
        var subtotal = 0
        for (order in orders){
            subtotal = subtotal+order.price
        }
        tvSubtotal.text="$$subtotal"
    }

    override fun displayRestaurantInfo(info: RestaurantVO) {
        Glide.with(this).load(info.image).into(ivRestaurant)
        tvRestaurantName.text = info.name
        tvDescription.text = info.description
        tvLocation.text = info.location
        tvRating.text = info.rating
    }

    override fun navigateToCheckoutScreen() {
        startActivity(CheckoutActivity.newIntent(this))
    }


}