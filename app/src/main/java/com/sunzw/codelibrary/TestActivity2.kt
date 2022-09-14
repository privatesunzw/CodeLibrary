package com.sunzw.codelibrary

import android.view.View
import com.didi.drouter.annotation.Router
import com.sunzw.codelibrary.databinding.ActivityTest2Binding
import com.sunzw.codelibrary.router.RouterPath
import com.sunzw.common.BaseActivity
import com.sunzw.common.utils.LogUtil

@Router(path = RouterPath.testActivity2)
class TestActivity2 : BaseActivity() {
    companion object {
        private const val TAG = "TestActivity2"
    }
    private lateinit var mViewBinding: ActivityTest2Binding
    override fun getContentView(): View {
        mViewBinding = ActivityTest2Binding.inflate(layoutInflater)
        return mViewBinding.root
    }

    override fun init() {

    }

    override fun onStart() {
        LogUtil.logI(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        LogUtil.logI(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        LogUtil.logI(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        LogUtil.logI(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        LogUtil.logI(TAG, "onDestroy")
        super.onDestroy()
    }
}