package com.liang.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    var datas= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
//        datas=getData()
/*        val adapter = MainAdapter(datas, this)
        val mg = GridLayoutManager(this, 2)
        val itemd =
            GridSpaceItemDecoration( 2,20,true)
        rlv_main_content.addItemDecoration(itemd)
        rlv_main_content.layoutManager = mg
        rlv_main_content.adapter = adapter
        btn_refresh.setOnClickListener {
            datas.addAll(getDatas(1))
            adapter.notifyDataSetChanged()
        }*/
    }


    fun getData(): MutableList<String> {
        val list = mutableListOf<String>()
        for (index in 0 until 50) {
            list.add("$index")
        }
        return list
    }
    fun getDatas(p:Int): MutableList<String> {
        val list = mutableListOf<String>()
        for (index in p until 5*p) {
            list.add("$index")
        }
        return list
    }
    inner class MainAdapter(var list: MutableList<String>, var mContext: Context) :
        RecyclerView.Adapter<MainAdapter.ViewHodle>() {
        private var mInflater: LayoutInflater? = null

        init {
            mInflater = LayoutInflater.from(mContext)
        }

        inner class ViewHodle(view: View) : RecyclerView.ViewHolder(view) {
            val tv = view.findViewById<TextView>(R.id.tv_item_content)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodle {
            return ViewHodle(mInflater!!.inflate(R.layout.item, null))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHodle, position: Int) {
            holder.tv.text = list[position]
        }


    }
}