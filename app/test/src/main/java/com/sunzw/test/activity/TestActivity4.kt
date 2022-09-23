package com.sunzw.test.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.didi.drouter.annotation.Router
import com.sunzw.common.BaseActivity
import com.sunzw.common.utils.LogUtil
import com.sunzw.test.R
import com.sunzw.test.RouterPath
import com.sunzw.test.adapter.ViewFragmentPagerAdapter
import com.sunzw.test.databinding.ActivityTest4Binding
import com.sunzw.test.fragment.TestFragment1
import com.sunzw.test.fragment.TestFragment2
import com.sunzw.test.fragment.TestFragment3
import com.sunzw.test.fragment.TestFragment4

@Router(path = RouterPath.TestActivity4)
class TestActivity4 : BaseActivity() {
    private lateinit var mViewBinding: ActivityTest4Binding
    override fun getContentView(): View {
        mViewBinding = ActivityTest4Binding.inflate(layoutInflater)
        return mViewBinding.root
    }

    override fun init() {
        val testFragment1 = TestFragment1.newInstance("", "")
        val testFragment2 = TestFragment2.newInstance("", "")
        val testFragment3 = TestFragment3.newInstance("", "")
        val testFragment4 = TestFragment4.newInstance("", "")
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.viewPager_content, testFragment1)
        fragmentTransaction.commit()
      //  mViewBinding.viewPagerContent.adapter= ViewFragmentPagerAdapter(supportFragmentManager,)

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

    override fun onSaveInstanceState(outState: Bundle) {
        LogUtil.logI("onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        LogUtil.logI("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        LogUtil.logI("onDestroy")
        super.onDestroy()
    }


}