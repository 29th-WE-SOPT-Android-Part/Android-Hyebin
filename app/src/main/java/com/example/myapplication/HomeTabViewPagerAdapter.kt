package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    val fragmentList = mutableListOf<Fragment>()
    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}