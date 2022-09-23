package com.sunzw.codelibrary

import android.content.Intent
import android.view.View
import com.didi.drouter.annotation.Router
import com.sunzw.codelibrary.databinding.ActivityMainBinding
import com.sunzw.codelibrary.router.RouterPath
import com.sunzw.common.BaseActivity


@Router(path = RouterPath.mainActivity)
class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun getContentView(): View {
        mBinding=ActivityMainBinding.inflate(layoutInflater)
       return mBinding.root
    }

    override fun init() {
        setOnClickListener(mBinding.tvSubmit)
    }

    override fun onClick(view: View) {
        when(view){
            mBinding.tvSubmit-> jumpActivity(RouterPath.testActivity3)
        }
    }

    override fun onRouterResult(url: String, resultCode: Int, data: Intent?) {
        when(url){
            RouterPath.testActivity3->{}

        }

    }


}