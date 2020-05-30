package com.liang.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zy.logcat.LogCatControl

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

    }
    fun btn01(view: View?) {
        //手动造成一个Crash
        throw  NullPointerException("自定义异常抛出2");
    }
}