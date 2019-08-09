package com.example.recycleview.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.example.recycleview.R
import com.example.recycleview.adapter.TablayoutAdapter
import kotlinx.android.synthetic.main.activity_tab_layout_view_pager.*

class TabLayoutViewPager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_view_pager)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        addControl()

    }

    private fun addControl() {
        val manager: FragmentManager = supportFragmentManager
        var adapter  = TablayoutAdapter(manager)
        view_pager.adapter =  adapter
        tablay_out.setupWithViewPager(view_pager)
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablay_out))
        tablay_out.setTabsFromPagerAdapter(adapter)
        tablay_out.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
