package com.example.happyfooddelivery.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.happyfooddelivery.R
import com.example.happyfooddelivery.activities.LoginActivity
import com.example.happyfooddelivery.activities.RegisterActivity
import com.example.happyfooddelivery.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_introduction.*

class IntroductionFragment : Fragment() {

    private lateinit var mContext: Context
    private lateinit var mPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_introduction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
        setUpListeners()
    }

    private fun setUpViewPager(){
        mPagerAdapter = ViewPagerAdapter(this)
        viewpager.adapter = mPagerAdapter

        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> {
                        btnCircle1.setImageDrawable(resources.getDrawable(R.drawable.circle_pink))
                        btnCircle2.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                        btnCircle3.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                    }
                    1 -> {
                        btnCircle1.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                        btnCircle2.setImageDrawable(resources.getDrawable(R.drawable.circle_pink))
                        btnCircle3.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                    }
                    2 -> {
                        btnCircle1.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                        btnCircle2.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                        btnCircle3.setImageDrawable(resources.getDrawable(R.drawable.circle_pink))
                    }
                    else -> {
                        btnCircle1.setImageDrawable(resources.getDrawable(R.drawable.circle_pink))
                        btnCircle2.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                        btnCircle3.setImageDrawable(resources.getDrawable(R.drawable.circle_gray))
                    }
                }
            }
        })
    }

    private fun setUpListeners(){
        btnLogin.setOnClickListener {
            startActivity(LoginActivity.newIntent(mContext))
        }

        btnCreateAccount.setOnClickListener {
            startActivity(RegisterActivity.newIntent(mContext))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }
}