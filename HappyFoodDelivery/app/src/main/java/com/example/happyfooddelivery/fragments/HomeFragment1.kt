package com.example.happyfooddelivery.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.activities.DetailsActivity
import com.example.happyfooddelivery.adapters.PopularChoiceAdapter
import com.example.happyfooddelivery.adapters.RestaurantAdapter
import com.example.happyfooddelivery.data.vos.RestaurantVO
import com.example.happyfooddelivery.mvp.presenters.HomePresenter1
import com.example.happyfooddelivery.mvp.presenters.impls.HomePresenter1Impl
import com.example.happyfooddelivery.mvp.views.HomeView1
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home1.*
import kotlinx.android.synthetic.main.fragment_home1.rvRestaurants
import kotlinx.android.synthetic.main.fragment_home2.*


class HomeFragment1 : Fragment(), HomeView1 {

    private lateinit var mPresenter : HomePresenter1
    private lateinit var mAdapter : RestaurantAdapter
    private lateinit var mPopularChoiceAdapter: PopularChoiceAdapter
    private lateinit var mContext: Context
    private lateinit var mView : View
    private val VIEW_TYPE = "VIEW_TYPE"
    private var mViewType : Int = 0

    companion object{
        fun newInstance(viewType : Int) = HomeFragment1().apply {
            arguments = Bundle().apply {
                putInt(VIEW_TYPE, viewType)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mViewType = it.getInt(VIEW_TYPE, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        when(mViewType){
            0 -> return inflater.inflate(R.layout.fragment_home1, container, false)
            1 -> return inflater.inflate(R.layout.fragment_home2, container, false)
            else -> return inflater.inflate(R.layout.fragment_home1, container, false)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mView = view
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady()
    }

    private fun setUpRecyclerView() {
        rvRestaurants.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        mAdapter = RestaurantAdapter(false, mPresenter)
        rvRestaurants.adapter = mAdapter

        rvPopularChoices?.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        mPopularChoiceAdapter = PopularChoiceAdapter()
        rvPopularChoices?.adapter = mPopularChoiceAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenter1Impl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayRestaurants(restaurants: List<RestaurantVO>) {
        mAdapter.setNewData(restaurants)
        mPopularChoiceAdapter.setNewData(restaurants.first().foods)
    }

    override fun navigateToDetailsView(id: Int) {
        startActivity(DetailsActivity.newIntent(mContext, id))
    }

    override fun showError(error: String) {
        Snackbar.make(mView, error, Snackbar.LENGTH_LONG).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}