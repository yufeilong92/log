package com.liang.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liang.myapplication.crashmonitor.MCrashMonitor
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private var mContext: Context? = null


//    private val textView: TextView? = null

  /*  *//**
     * 抛出自定义异常
     *//*
    private val mBtnThrowException: Button? = null

    *//**
     * 日志列表页面
     *//*
    private val mBtnLogList: Button? = null

    *//**
     * 下一页
     *//*
    private val mBtnNextPage: Button? = null

    *//**
     * 添加额外的Log信息
     *//*
    private val mBtnAddExtraInfo: Button? = null

    *//**
     * 获取日志保存路径
     *//*
    private val mBtnGetLogPath: Button? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mContext = this
        textView.text="${"22d".toInt()}"
        btn_throw_exception.setOnClickListener {
            throwException()
        }
        btn_log_list.setOnClickListener {
            //打开日志列表
            MCrashMonitor.startCrashListPage(mContext)
        }
        btn_next_page.setOnClickListener {
            startActivity(Intent(mContext, MainActivity3::class.java))
        }
        btn_add_extra_info.setOnClickListener {
            val extraInfo = """
                用户手机号码：16666666666
                用户网络环境：xxx
                """.trimIndent()
            MCrashMonitor.setCrashLogExtraInfo(extraInfo)
        }
        btn_get_log_path.setOnClickListener {
            val crashLogFilesPath = MCrashMonitor.getCrashLogFilesPath(this)
            Toast.makeText(this, "崩溃日志文件夹的路径：$crashLogFilesPath", Toast.LENGTH_SHORT).show()
            textView!!.text = "崩溃日志文件夹的路径：\n$crashLogFilesPath"
        }

    }
    private fun throwException() {
        //手动造成一个Crash
        throw NullPointerException("自定义异常抛出")
    }
}