package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var studentList = arrayListOf<Student>(
        Student(1315, "임세현", "android"),
        Student(1315, "임세현", "android"),
        Student(1315, "임세현", "android")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvStudent: RecyclerView = findViewById(R.id.rvStudent)

        val mAdapter = MainRvAdapter(this, studentList)
        rvStudent.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        rvStudent.layoutManager = lm
        rvStudent.setHasFixedSize(true)
    }
}