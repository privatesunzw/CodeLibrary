package com.sunzw.test.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.didi.drouter.annotation.Router
import com.google.android.material.tabs.TabLayoutMediator
import com.sunzw.common.BaseActivity
import com.sunzw.common.utils.LogUtil
import com.sunzw.test.R
import com.sunzw.test.RouterPath
import com.sunzw.test.TestConstant
import com.sunzw.test.adapter.ViewFragmentPagerAdapter
import com.sunzw.test.databinding.ActivityTest3Binding
import com.sunzw.test.fragment.TestFragment1
import com.sunzw.test.fragment.TestFragment2
import com.sunzw.test.fragment.TestFragment3
import com.sunzw.test.fragment.TestFragment4


@Router(path = RouterPath.TestActivity3)
class TestActivity3 : BaseActivity() {

    private lateinit var mViewBinding: ActivityTest3Binding
    private var mFragmentList = mutableListOf<Fragment>()
    private var mTabLayoutTextList = mutableListOf<String>()

    override fun getContentView(): View {
        mViewBinding = ActivityTest3Binding.inflate(layoutInflater)
        return mViewBinding.root
    }

    override fun init() {
        initTabLayout()
        initFragment()
        //初viewpager添加fragment适配器
        mViewBinding.viewPager2.adapter = ViewFragmentPagerAdapter(this, mFragmentList)
        //绑定viewpager和tabLayout
        TabLayoutMediator(mViewBinding.tabLayout, mViewBinding.viewPager2) { tab, position ->
            tab.customView = getTabView(position)
        }.attach()
    }

    override fun initBundle() {

    }

    /**
     * 初始化TabLayout，并添加进mTabLayoutTextList
     * */
    private fun initTabLayout() {
        for (str in TestConstant.arrayMainTabLayout) {
            mTabLayoutTextList.add(str)
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun getTabView(position: Int): View {
        val view: View = LayoutInflater.from(this).inflate(R.layout.tab_layout_test, null)
        val imageView = view.findViewById<ImageView>(R.id.iv_tab_layout)
        val textView = view.findViewById<TextView>(R.id.tv_tab_layout)
        imageView.setImageResource(TestConstant.tabs[position].second)
        textView.text = TestConstant.tabs[position].first
        return view
    }

    /**
     * 初始化fragment，并添加进mFragmentList
     * */
    private fun initFragment() {
        mFragmentList.apply {
            add(TestFragment1())
            add(TestFragment2())
            add(TestFragment3())
            add(TestFragment4())
        }
    }

    override fun onClick(view: View) {
        when (view) {

        }
    }

    override fun onNewIntent(intent: Intent?) {
        LogUtil.logI("onNewIntent")
        super.onNewIntent(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.logI("onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onRestart() {
        LogUtil.logI("onRestart")
        super.onRestart()
    }

    override fun onStart() {
        LogUtil.logI("onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        LogUtil.logI("onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        LogUtil.logI("onResume")
        super.onResume()
    }

    override fun onPause() {
        LogUtil.logI("onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        LogUtil.logI("onSaveInstanceState")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onStop() {
        LogUtil.logI("onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        LogUtil.logI("onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }


    override fun onDestroy() {
        LogUtil.logI("onDestroy")
        super.onDestroy()
    }


}