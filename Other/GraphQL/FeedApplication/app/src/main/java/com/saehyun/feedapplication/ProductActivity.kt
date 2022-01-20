package com.saehyun.feedapplication

import PostProductQuery
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.saehyun.feedapplication.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getDoubleExtra("id", 0.0)

        getData(name)
    }

    private fun getData(id: Double) {
        ApiProvider.apolloClient.query(PostProductQuery(id))
            .enqueue(object : ApolloCall.Callback<PostProductQuery.Data>() {
                override fun onResponse(response: Response<PostProductQuery.Data>) {
                    val data = response.data?.getProduct

                    setData(data!!)

                }

                override fun onFailure(e: ApolloException) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    private fun setData(data: PostProductQuery.GetProduct) {
        runOnUiThread {
            binding.tvTitle.text = data.name
            binding.tvPrice.text = data.price.toString()
        }
    }
}