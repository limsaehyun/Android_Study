package com.moizaandroid.moizaarchitecturesample.data.local.datasource

import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse

interface LocalPostDataSource {
    suspend fun fetchPost(): PostResponse
}