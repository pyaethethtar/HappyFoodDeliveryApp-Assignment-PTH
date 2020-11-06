package com.example.happyfooddelivery.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.happyfooddelivery.fragments.FastDeliveryFragment
import com.example.happyfooddelivery.fragments.FindFoodsFragment
import com.example.happyfooddelivery.fragments.LiveTrackingFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return FindFoodsFragment()
            1 -> return FastDeliveryFragment()
            2 -> return LiveTrackingFragment()
            else -> return FindFoodsFragment()
        }
    }
}