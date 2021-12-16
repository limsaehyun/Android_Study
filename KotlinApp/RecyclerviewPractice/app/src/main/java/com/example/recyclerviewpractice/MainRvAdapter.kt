package com.example.recyclerviewpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRvAdapter(val context: Context, val studentList: ArrayList<Student>):
    RecyclerView.Adapter<MainRvAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val studentNum = itemView?.findViewById<TextView>(R.id.tvStudentNum)
        val name = itemView?.findViewById<TextView>(R.id.tvName)
        val major = itemView?.findViewById<TextView>(R.id.tvMajor)

        fun bind(student: Student, context: Context) {
            studentNum?.text = student.studentNum.toString()
            name?.text = student.name
            major?.text = student.major
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_rv_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(studentList[position], context)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}