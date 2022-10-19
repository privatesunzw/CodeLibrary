package com.sunzw.test

class TestConstant {
    companion object {
        val arrayMainTabLayout = arrayListOf("首页", "资讯", "发现", "我", "你")
        val tabs = arrayOf(
            "首页" to R.drawable.ic_launcher_background,
            "资讯" to R.drawable.ic_launcher_background,
            "发现" to R.drawable.ic_launcher_background,
            Pair("我的", R.drawable.ic_launcher_background)
        )
    }
}