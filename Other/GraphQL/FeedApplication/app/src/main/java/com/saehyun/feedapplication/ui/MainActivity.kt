package com.saehyun.feedapplication.ui

import GetProductsQuery
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.saehyun.feedapplication.network.ApiProvider
import com.saehyun.feedapplication.MainAdapter
import com.saehyun.feedapplication.R
import com.saehyun.feedapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var rvData = arrayListOf<GetProductsQuery.GetProduct>()

    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            toggleFab()
        }

        binding.fabEdit.setOnClickListener {
            startActivity(Intent(applicationContext, CreateActivity::class.java))
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter = MainAdapter(applicationContext, rvData)
    }

    override fun onResume() {
        super.onResume()

        ApiProvider.apolloClient.query(GetProductsQuery())
            .enqueue(object : ApolloCall.Callback<GetProductsQuery.Data>() {
                override fun onResponse(response: Response<GetProductsQuery.Data>) {
                    val data = response.data?.getProducts

                    setData(data!!)

                }

                override fun onFailure(e: ApolloException) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    private fun setData(data: List<GetProductsQuery.GetProduct>) {
        runOnUiThread {
            for (i: Int in 0..data.size - 1) {
                rvData.add(data.get(i))
            }

            binding.rv.adapter?.notifyDataSetChanged()
        }
    }

    private fun toggleFab() {
        if (isFabOpen) {
            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", 0f).apply { start() }
            binding.fab.setImageResource(R.drawable.ic_baseline_add_24)

        } else {
            ObjectAnimator.ofFloat(binding.fabEdit, "translationY", -200f).apply { start() }
            binding.fab.setImageResource(R.drawable.ic_baseline_clear_24)
        }

        isFabOpen = !isFabOpen

    }
}
