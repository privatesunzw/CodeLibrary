package com.sunzw.test.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Html
import android.view.View
import androidx.annotation.RequiresApi
import com.didi.drouter.annotation.Router
import com.sunzw.common.BaseActivity
import com.sunzw.common.utils.LogUtil
import com.sunzw.test.RouterPath
import com.sunzw.test.databinding.ActivityTest3Binding

@Router(path = RouterPath.TestActivity3)
class TestActivity3 : BaseActivity() {

    private lateinit var mViewBinding: ActivityTest3Binding
    override fun getContentView(): View {
        mViewBinding = ActivityTest3Binding.inflate(layoutInflater)
        return mViewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun init() {
        var sources =
            "<div style=\"font-size:3; color:#666666\">系统检测到您在<span style=\"color:#FF2200\">【门诊发票】</span>栏位上传的影像\n" +
                    "    非门诊发票材料，请您上传正确的门诊发票材料。</div>"
        var sources2 =
            "<p><font size=\"3\" color=\"red\">设置了字号和颜色</font></p>\" +\n<b><font size=\"5\" color=\"blue\">设置字体加粗 蓝色 5号</font></font></b></br>\" +\n\"<h1>这个是H1标签</h1></br>\" +\n\"<p>这里显示图片：</p>"
//        HtmlFromUtils.setTextFromHtml(
//            this,
//            mViewBinding.tvSubmit,
//            "<div style=\"font-size: 60px; color:#666666\">系统检测到您在<span style=\"color:#FF2200\">【门诊发票】</span>栏位上传的影像\n" +
//                    "    非门诊发票材料，请您上传正确的门诊发票材料。</div>"
//        )
        // mViewBinding.tvSubmit.textSize= 60F
        mViewBinding.tvSubmit.text = Html.fromHtml(sources2, Html.FROM_HTML_MODE_COMPACT)
        setOnClickListener(mViewBinding.tvSubmit)
    }

    override fun initBundle() {

    }

    override fun onClick(view: View) {
        when (view) {
            mViewBinding.tvSubmit -> jumpActivity(RouterPath.TestActivity4)
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