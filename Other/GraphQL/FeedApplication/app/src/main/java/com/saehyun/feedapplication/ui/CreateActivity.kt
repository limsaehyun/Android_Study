package com.saehyun.feedapplication.ui

import CreateMutation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.saehyun.feedapplication.network.ApiProvider
import com.saehyun.feedapplication.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val price = binding.etPrice.text.toString().toInt()

            create(title, price)
        }
    }

    private fun create(name: String, price: Int) {
        ApiProvider.apolloClient.mutate(CreateMutation(name, price))
            .enqueue(object : ApolloCall.Callback<CreateMutation.Data>() {
                override fun onResponse(response: Response<CreateMutation.Data>) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "success!", Toast.LENGTH_SHORT).show()
                        finish()
                    }

                }

                override fun onFailure(e: ApolloException) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

}