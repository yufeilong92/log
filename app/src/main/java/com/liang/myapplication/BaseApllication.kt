package com.liang.myapplication

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import com.liang.myapplication.crashmonitor.MCrashMonitor
import com.liang.myapplication.crashmonitor.listener.MCrashCallBack
import com.liang.myapplication.log.SaveHttpLog
import java.io.File

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.liang.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/5/30 13:17
 * @Purpose :
 */
class BaseApllication:Application() {
    companion object{
        val TAG = "MyApplication"
    }
    private var myApplication:BaseApllication? = null
    override fun onCreate() {
        super.onCreate()
        myApplication=this
        initCrashMonitor()
        SaveHttpLog().init(this)
    }

    fun getInstance():BaseApllication? {
        return myApplication
    }

    private fun initCrashMonitor() {
        /**
         * 初始化日志系统
         * context :    上下文
         * isDebug :    是不是Debug模式,true:崩溃后显示自定义崩溃页面 ;false:关闭应用,不跳转奔溃页面(默认)
         * CrashCallBack : 回调执行
         */
        MCrashMonitor.init(this, true, object : MCrashCallBack {
           override fun onCrash(file: File) {
                //可以在这里保存标识，下次再次进入把日志发送给服务器
                Log.i(
                   BaseApllication.TAG,
                    "CrashMonitor回调:" + file.absolutePath
                )
            }
        })
    }
}