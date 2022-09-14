package com.sunzw.common.utils

import com.orhanobut.logger.*
import com.sunzw.common.GlobalConstant


/**
 * @author szw
 * 封装logger
 */
object LogUtil {

    /**
     *  PrettyFormatStrategy.newBuilder()构建可选属性
     *  showThreadInfo(false)    （可选）是否显示线程信息。 默认值为true
     *  methodCount(3)           (可选）要显示的方法行数。 默认2
     *  methodOffset(0)        （可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
     *  logStrategy(customLog)  （可选）更改要打印的日志策略。 默认LogCat
     *  tag("Logger")          //（可选）TAG内容. 默认是 PRETTY_LOGGER
     *
     *  isLoggable（）方法返回值可以控制log日志的开关
     *
     *  支持占位符
     */

    init {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(1)
            .methodOffset(1)
            .logStrategy(LogcatLogStrategy())
            .tag(GlobalConstant.TAG)
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return GlobalConstant.isShowLog
            }
        })
    }

    fun logI(msg: String) {
        Logger.i(msg, null)
    }

    fun logI(msg: String, vararg args: Any?) {
        Logger.i(msg, *args)
    }

    fun logD(msg: Any?) {
        Logger.d(msg)
    }

    fun logD(msg: String, vararg args: Any?) {
        Logger.d(msg, *args)
    }

    fun logE(msg: String) {
        Logger.e(msg, null)
    }

    fun logE(msg: String, vararg args: Any?) {
        Logger.e(msg, *args)
    }


    fun logE(throwable: Throwable, msg: String, vararg args: Any?) {
        Logger.e(throwable, msg, *args)
    }


    fun logXML(msg: String?) {
        Logger.xml(msg)
    }

    fun logJSON(msg: String?) {
        Logger.json(msg)
    }

    fun logWTF(msg: String, vararg args: Any?) {
        Logger.wtf(msg, args)
    }


}
