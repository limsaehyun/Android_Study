package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rvStudent: RecyclerView

    var studentList = arrayListOf<Student>(
        Student(1315, "임세현", "android"),
        Student(1315, "임세현", "android"),
        Student(1315, "임세현", "android")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStudent = findViewById(R.id.rvStudent)

        val mAdapter = MainRvAdapter(this, studentList)
        rvStudent.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        rvStudent.layoutManager = lm
        rvStudent.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()

        // 코드로 추가
        val student = Student(1111, "테스트", "테스트")
        studentList.add(student)
        rvStudent.adapter?.notifyDataSetChanged()
    }
}