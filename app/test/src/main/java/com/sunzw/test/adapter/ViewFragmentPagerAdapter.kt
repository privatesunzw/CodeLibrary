package com.sunzw.test.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewFragmentPagerAdapter(
    private val fm: FragmentManager,
    private val lifecycle: Lifecycle,
    private val list: List<Fragment>
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}