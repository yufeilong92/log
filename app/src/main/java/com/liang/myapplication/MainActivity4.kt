package com.liang.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.donkingliang.imageselector.utils.ImageSelector
import kotlinx.android.synthetic.main.activity_main4.*
import java.util.ArrayList

class MainActivity4 : AppCompatActivity() {
    private val REQUEST_CODE = 1001

    val selected = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        btn_one.setOnClickListener {
            ImageSelector.builder()
                .useCamera(true)
                .setSingle(true)
                .canPreview(true)
                .start(this, REQUEST_CODE)
        }
        btn_two.setOnClickListener {
//限数量的多选(比如最多9张)
            ImageSelector.builder()
                .useCamera(true) // 设置是否使用拍照
                .setSingle(false)  //设置是否单选
                .setMaxSelectCount(9) // 图片的最大选择数量，小于等于0时，不限数量。
                .setSelected(selected as ArrayList<String>?) // 把已选的图片传入默认选中。
                .canPreview(true) //是否可以预览图片，默认为true
                .start(this, REQUEST_CODE); // 打开相册
        }
        btn_three.setOnClickListener {
//不限数量的多选
            ImageSelector.builder()
                .useCamera(true) // 设置是否使用拍照
                .setSingle(false)  //设置是否单选
                .setMaxSelectCount(0) // 图片的最大选择数量，小于等于0时，不限数量。
                .setSelected(selected as ArrayList<String>?) // 把已选的图片传入默认选中。
                .canPreview(true) //是否可以预览图片，默认为true
                .start(this, REQUEST_CODE); // 打开相册
        }
        btn_four.setOnClickListener {
//单选并剪裁
            ImageSelector.builder()
                .useCamera(true) // 设置是否使用拍照
                .setCrop(true)  // 设置是否使用图片剪切功能。
                .setCropRatio(1.0f) // 图片剪切的宽高比,默认1.0f。宽固定为手机屏幕的宽。
                .setSingle(true)  //设置是否单选
                .canPreview(true) //是否可以预览图片，默认为true
                .start(this, REQUEST_CODE); // 打开相册
        }
        btn_five.setOnClickListener {
//仅拍照
            ImageSelector.builder()
                .onlyTakePhoto(true)  // 仅拍照，不打开相册
                .start(this, REQUEST_CODE);
        }
        btn_six.setOnClickListener {
//拍照并剪裁
            ImageSelector.builder()
                .setCrop(true) // 设置是否使用图片剪切功能。
                .setCropRatio(1.0f) // 图片剪切的宽高比,默认1.0f。宽固定为手机屏幕的宽。
                .onlyTakePhoto(true)  // 仅拍照，不打开相册
                .start(this, REQUEST_CODE);
        }
        var list:MutableList<String>?=null
        val function: (v: View) -> Unit = {
            list= mutableListOf()
            Log.e("==", "")
        }
        btn_seven.setOnClickListener(function)
        search_text.setEditoAcitonListener {
            Toast.makeText(this@MainActivity4, "$it", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        }
        if (requestCode == REQUEST_CODE) {
            val imgs = data.getStringArrayListExtra(ImageSelector.SELECT_RESULT)

            /**
             * 是否是来自于相机拍照的图片，
             * 只有本次调用相机拍出来的照片，返回时才为true。
             * 当为true时，图片返回的结果有且只有一张图片。
             */
            val booleanExtra = data.getBooleanExtra(ImageSelector.IS_CAMERA_IMAGE, false)
            Log.e("==", "$booleanExtra")

            if (imgs.isNullOrEmpty()) return

            imgs.forEach {
                Log.e("==", it)
            }
        }
    }
}