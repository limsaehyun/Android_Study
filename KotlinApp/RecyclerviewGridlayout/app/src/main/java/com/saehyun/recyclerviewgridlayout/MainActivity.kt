package com.saehyun.recyclerviewgridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.saehyun.recyclerviewgridlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var feedList = arrayListOf<MainData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        feedList.add(MainData("1"))
        feedList.add(MainData("2"))
        feedList.add(MainData("3"))


        binding.rv.adapter = MainAdapter(applicationContext, feedList)
        binding.rv.layoutManager = GridLayoutManager(this, 2)
        binding.rv.setHasFixedSize(true)

        binding.rv.adapter?.notifyDataSetChanged()


    }
}