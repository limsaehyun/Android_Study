package com.saehyun.recyclerviewgridlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val context: Context, val feedList: ArrayList<MainData>):
    RecyclerView.Adapter<MainAdapter.Holder>(){

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val iv = itemView?.findViewById<ImageView>(R.id.iv)
        val tv = itemView?.findViewById<TextView>(R.id.tv)

        lateinit var userName: String

        fun bind(mainData: MainData, context: Context) {
            tv?.text = mainData.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(feedList[position], context)
    }

    override fun getItemCount(): Int {
        return feedList.size
    }
}