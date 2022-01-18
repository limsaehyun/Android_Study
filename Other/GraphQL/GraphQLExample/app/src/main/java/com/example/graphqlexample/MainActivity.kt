package com.example.graphqlexample

import FeedResultQuery
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apolloClient = ApolloClient.builder()
            .serverUrl("https://rickandmortyapi.com/graphql/")
            .build()

        apolloClient.query(FeedResultQuery())
            .enqueue(object : ApolloCall.Callback<FeedResultQuery.Data>() {
                override fun onResponse(response: Response<FeedResultQuery.Data>) {
                    Log.d(TAG, "onResponse: ${response.data?.characters?.results}")
                }

                override fun onFailure(e: ApolloException) {
                    Log.d(TAG, "onFailure: ")
                }
            })
    }
}
