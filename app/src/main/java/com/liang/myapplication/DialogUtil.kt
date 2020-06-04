package com.liang.myapplication

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.dialog_item.*

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.liang.myapplication
 * @Email : yufeilong92@163.com
 * @Time :2020/6/3 10:12
 * @Purpose :
 */
object DialogUtil {


    fun showDialog(mContext: Context) {
        val dialog = object : GmDialog(
            mContext = mContext,
            id = R.layout.dialog_item,
            mGravity = Gravity.CENTER
        ) {
            override fun initViewData() {
                tv_dialog_life.setOnClickListener {
                    dismiss()
                    Toast.makeText(mContext, "life", Toast.LENGTH_SHORT).show();
                }
                tv_dialog_right.setOnClickListener {
                    dismiss()
                    Toast.makeText(mContext, "right", Toast.LENGTH_SHORT).show();
                }
            }
        }
        dialog.setCancelable(true)
        dialog.show()

    }
}