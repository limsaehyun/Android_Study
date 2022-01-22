package com.saehyun.feedapplication.network

import com.apollographql.apollo.ApolloClient

object ApiProvider {
    val apolloClient = ApolloClient.builder()
        .serverUrl("http://13.209.176.77:80/graphql")
        .build()
}