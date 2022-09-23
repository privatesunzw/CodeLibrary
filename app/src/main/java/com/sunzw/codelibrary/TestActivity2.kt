package com.sunzw.codelibrary

import android.content.Intent
import android.view.View
import com.didi.drouter.annotation.Router
import com.sunzw.codelibrary.databinding.ActivityTest2Binding
import com.sunzw.codelibrary.router.RouterPath
import com.sunzw.common.BaseActivity

import com.sunzw.common.utils.LogUtil

@Router(path = RouterPath.testActivity2)
class TestActivity2 : BaseActivity() {
    private lateinit var mViewBinding: ActivityTest2Binding
    override fun getContentView(): View {
        mViewBinding = ActivityTest2Binding.inflate(layoutInflater)
        return mViewBinding.root
    }

    override fun init() {

    }

    override fun onNewIntent(intent: Intent?) {
        LogUtil.logI("onNewIntent")
        super.onNewIntent(intent)
    }
    override fun onRestart() {
        LogUtil.logI("onRestart")
        super.onRestart()
    }

    override fun onStart() {
        LogUtil.logI("onStart")
        super.onStart()
    }

    override fun onResume() {
        LogUtil.logI("onResume")
        super.onResume()
    }

    override fun onPause() {
        LogUtil.logI("onPause")
        super.onPause()
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