package com.liang.myapplication.PermissionUtil

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AlertDialog

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.liang.myapplication.PermissionUtil
 * @Email : yufeilong92@163.com
 * @Time :2020/6/2 13:53
 * @Purpose :请求权限
 */
class PermissionUtil {
    companion object{
        val PermissionRequestCode=10001
    }

    fun initPerMission(
        com: Activity,
         permissions :MutableList<String>,
        title: String,
        sure: String,
        cancle: String,no:()->Unit

    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissions.isNullOrEmpty()) {
                return
            }
            val list = mutableListOf<String>()
            for (permission in permissions) {
                list.add(permission)
            }
            showReuqestPersmission(com, list,title,sure,cancle,no)
        }
    }

    private fun showReuqestPersmission(
        context: Activity,
        permissions: MutableList<String>,
        title: String,
        sure: String,
        cancle: String,no:()->Unit
    ) {
        if (permissions.isNullOrEmpty()) {
            return
        }
       AlertDialog.Builder(context)
            .setTitle(title)
            .setPositiveButton(
                sure
            ) { dialog, which ->
                startRequestPerMission(context,permissions)
            }
            .setNegativeButton(cancle) { dialog, which ->
                no()
            }
            .setCancelable(false).show()
    }

    private fun startRequestPerMission(ac:Activity,list:MutableList<String>){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ac.requestPermissions(list.toTypedArray(),PermissionRequestCode)
        }
    }


}