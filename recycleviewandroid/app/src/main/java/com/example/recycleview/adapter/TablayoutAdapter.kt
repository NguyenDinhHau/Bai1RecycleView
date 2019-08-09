package com.example.recycleview.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import com.example.recycleview.fragment.FragmentA
import com.example.recycleview.fragment.FragmentB
import com.example.recycleview.fragment.FragmentC

class TablayoutAdapter( fm:FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        var fragment : Fragment? = null
        when(p0){
            0 -> {
                fragment = FragmentA()
            }
            1 -> {
                fragment = FragmentB()
            }
            2 -> {
                fragment = FragmentC()
            }
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String = ""
        when(position){
            0 ->{
                title = "Tab 1"
            }
            1 ->{
                title = "Tab 2"
            }
            2 ->{
                title = "Tab 3"
            }
        }
        return title
    }

    override fun getCount(): Int = 3
}