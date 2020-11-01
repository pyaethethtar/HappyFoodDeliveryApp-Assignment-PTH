package com.example.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.adapters.MenuAdapter
import com.example.happyfooddelivery.adapters.FoodAdapter
import com.example.happyfooddelivery.data.vos.FoodVO
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.mvp.presenters.DetailsPresenter
import com.example.happyfooddelivery.mvp.presenters.impls.DetailsPresenterImpl
import com.example.happyfooddelivery.mvp.views.DetailsView
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity(), DetailsView {

    private var restaurantId : Int = 1
    private lateinit var mPresenter : DetailsPresenter
    private lateinit var mFoodAdapter: FoodAdapter
    private lateinit var mMenuAdapter: MenuAdapter
    private var itemCount : Int  = 0

    companion object{
        const val RESTAURANT_ID_EXTRA = "RESTAURANT_ID_EXTRA"
        fun newIntent(context: Context, id: Int) : Intent{
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(RESTAURANT_ID_EXTRA, id)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        restaurantId = intent.getIntExtra(RESTAURANT_ID_EXTRA, 1)
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(restaurantId)

        btnGoToCart.setOnClickListener {
            mPresenter.onTapGoToCart()
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        rvPopularChoices.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mFoodAdapter = FoodAdapter(mPresenter)
        rvPopularChoices.adapter = mFoodAdapter

        rvMenu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mMenuAdapter = MenuAdapter(mPresenter)
        rvMenu.adapter = mMenuAdapter
    }

    override fun displayRestaurantInfo(info: RestaurantVO) {
        Glide.with(this).load(info.image).into(ivDetails)
        tvName.text = info.name
        tvRating.text = info.rating
        tvDescription.text = info.description
        tvLocation.text = info.location
    }

    override fun displayPopularFoods(foods: List<FoodVO>) {
        mFoodAdapter.setNewData(foods)
    }

    override fun displayMenuItems(items: List<FoodVO>) {
        mMenuAdapter.setNewData(items)
    }

    override fun addItemCount() {
        itemCount++
        btnGoToCart.text = "${itemCount} items in cart"
    }

    override fun goToCart() {
        startActivity(OrderActivity.newIntent(this, restaurantId))
    }
}