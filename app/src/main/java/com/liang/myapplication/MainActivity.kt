package com.liang.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zy.logcat.LogCatControl
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var timer: Timer? = null
    private var task: TimerTask? = null
    private var isStop = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 默认
     *
     * @param view
     */
    fun onTest(view: View?) {
        LogCatControl.getBuilder(this).clear()
        LogCatControl.getBuilder(this).show()
    }


    /**
     * 自定义标题
     *
     * @param view
     */
    fun onTest2(view: View?) {
        LogCatControl.getBuilder(this).clear()
        LogCatControl.getBuilder(this).setTitle("test").show()
    }


    /**
     * 自定义搜索内容
     *
     * @param view
     */
    fun onTest3(view: View?) {
        LogCatControl.getBuilder(this).clear()
        LogCatControl.getBuilder(this).setSearchContent("search").show()
    }


    /**
     * 自定义tag
     *
     * @param view
     */
    fun onTest4(view: View?) {
        LogCatControl.getBuilder(this).clear()
        LogCatControl.getBuilder(this).setSearchTag("MainActivity").show()
    }


    /**
     * 自定义log级别
     *
     * @param view
     */
    fun onTest5(view: View?) {
        LogCatControl.getBuilder(this).clear()
        LogCatControl.getBuilder(this).setShowGrade(3).show()
    }

    /**
     * 清除dialog
     *
     * @param view
     */
    fun onClear(view: View?) {
        LogCatControl.getBuilder(this).clear()
    }
    /**
     * 清除dialog
     *
     * @param view
     */
    fun onStart(view: View?) {
        startActivity(Intent(this,MainActivity2::class.java))
    }

    /**
     * 启动定时器
     *
     * @param view
     */
    fun onTimer(view: View?) {
        startTimer()
    }

    /**
     * 停止定时器
     *
     * @param view
     */
    fun onTimeroff(view: View?) {
        stopTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
        LogCatControl.getBuilder(this).clear()
    }

    private fun startTimer() {
        if (isStop) {
            timer = Timer()
            task = object : TimerTask() {
                override fun run() {
                    Log.i(
                        TAG,
                        "log i " + System.currentTimeMillis()
                    )
                    Log.d(
                        TAG,
                        "log d " + System.currentTimeMillis()
                    )
                    Log.v(
                        TAG,
                        "log v " + System.currentTimeMillis()
                    )
                    Log.w(
                        TAG,
                        "log w " + System.currentTimeMillis()
                    )
                    Log.wtf(
                        TAG,
                        "log wtf " + System.currentTimeMillis()
                    )
                    Log.e(
                        TAG,
                        "log e " + System.currentTimeMillis()
                    )
                }
            }
            timer!!.schedule(task, 0, 2000)
            isStop = false
        }
    }

    private fun stopTimer() {
        if (!isStop) {
            task!!.cancel()
            timer!!.cancel()
            task = null
            timer = null
            isStop = true
        }
    }
}