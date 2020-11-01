package com.example.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.fragments.HomeFragment1
import com.example.happyfooddelivery.fragments.ProfileFragment
import com.example.happyfooddelivery.mvp.presenters.MainPresenter
import com.example.happyfooddelivery.mvp.presenters.impls.MainPresenterImpl
import com.example.happyfooddelivery.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    private lateinit var mPresenter : MainPresenter

    companion object{
        fun newIntent(context: Context) : Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        mPresenter.onUiReady()

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_restaurants -> {
                    mPresenter.onTapRestaurants()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.item_account -> {
                    mPresenter.onTapAccount()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    fun openFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }

    override fun navigateToRestaurantsScreen(viewType : Int) {
        openFragment(HomeFragment1.newInstance(viewType))
    }

    override fun navigateToProfileScreen(email : String) {
        openFragment(ProfileFragment.newInstance(email))
    }

}