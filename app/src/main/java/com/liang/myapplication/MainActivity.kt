package com.liang.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liang.myapplication.PermissionUtil.PermissionName
import com.liang.myapplication.PermissionUtil.PermissionUtil
import com.liang.myapplication.log.LogCatControl
import com.liang.myapplication.log.SaveHttpLog
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var timer: Timer? = null
    private var task: TimerTask? = null
    private var isStop = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionUtil().initPerMission(this,
            mutableListOf(
                PermissionName.READ_EXTERNAL_STORAGE,
                PermissionName.WRITE_EXTERNAL_STORAGE,
                PermissionName.CAMERA,
                PermissionName.ACCESS_COARSE_LOCATION
            ),
            "权限提示",
            "确认",
            "取消"
        ) {
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PermissionUtil.PermissionRequestCode -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (grantResults.size > 0) {
                        for (item in grantResults) {
                            when (item) {
                                PackageManager.PERMISSION_GRANTED -> {
                                    Toast.makeText(this@MainActivity, "权限获取成功", Toast.LENGTH_SHORT)
                                        .show();
                                }
                                PackageManager.PERMISSION_DENIED -> {
                                    Toast.makeText(this@MainActivity, "权限获取失败", Toast.LENGTH_SHORT)
                                        .show();
                                }
                            }
                        }
                    }
                }
            }
        }

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

    fun showDialog(view:View?){
        startActivity(Intent(this,MainActivity4::class.java))
//        DialogUtil.showDialog(mContext = this)
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
        startActivity(Intent(this, MainActivity2::class.java))
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