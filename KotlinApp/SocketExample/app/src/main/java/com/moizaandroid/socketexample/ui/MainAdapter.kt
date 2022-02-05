package com.moizaandroid.socketexample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moizaandroid.socketexample.R
import com.moizaandroid.socketexample.model.Message

class MainAdapter(val context: Context, val data: ArrayList<Message>):
    RecyclerView.Adapter<MainAdapter.Holder>() {

    val CHAT_MINE = 0
    val CHAT_PARTNER = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view : View? = null

        when(viewType) {
            CHAT_MINE -> {
                view = LayoutInflater.from(context).inflate(R.layout.item_view_mine,parent,false)
            }
            CHAT_PARTNER -> {
                view = LayoutInflater.from(context).inflate(R.layout.item_view_partner,parent,false)
            }
        }
        return Holder(view!!)
    }

    inner class Holder(itemView : View):  RecyclerView.ViewHolder(itemView) {
        val tvChat = itemView.findViewById<TextView>(R.id.tvChat)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = data.get(position)
        val message = data.message
        val name = data.name
        val viewType = data.viewType

        when(viewType) {
            CHAT_MINE -> {
                holder.tvChat?.text = message
                holder.tvName?.text = name
            }
            CHAT_PARTNER -> {
                holder.tvChat?.text = message
                holder.tvName?.text = name
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].viewType
    }
}