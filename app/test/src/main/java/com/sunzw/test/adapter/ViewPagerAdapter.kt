package com.sunzw.test.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val context: Context, private val list: MutableList<String>) :PagerAdapter() {
    override fun getCount(): Int {
       return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        return position
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       // super.destroyItem(container, position, `object`)
        container.removeView(`object` as View?)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view==`object`
    }
}