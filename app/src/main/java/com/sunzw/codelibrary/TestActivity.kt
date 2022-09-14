package com.sunzw.codelibrary

import android.view.View
import com.didi.drouter.annotation.Router
import com.sunzw.codelibrary.databinding.ActivityTestBinding
import com.sunzw.codelibrary.router.RouterPath
import com.sunzw.common.BaseActivity
import com.sunzw.common.utils.LogUtil

@Router(path = RouterPath.testActivity)
class TestActivity : BaseActivity() {
    companion object {
        private const val TAG = "TestActivity"
    }
    lateinit var mViewBinding: ActivityTestBinding

    override fun getContentView(): View {
        mViewBinding = ActivityTestBinding.inflate(layoutInflater)
        return mViewBinding.root
    }

    override fun init() {
        LogUtil.logI("111111111111111", TAG)
        LogUtil.logI("222222222222222",TAG)
        LogUtil.logI("333333333333333",TAG)
        LogUtil.logI("444444444444444",TAG)
        LogUtil.logI("555555555555555",TAG)
        LogUtil.logI("666666666666666",TAG)
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