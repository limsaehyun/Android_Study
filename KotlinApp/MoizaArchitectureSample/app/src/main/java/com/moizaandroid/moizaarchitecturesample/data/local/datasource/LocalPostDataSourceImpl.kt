package com.moizaandroid.moizaarchitecturesample.data.local.datasource

import com.moizaandroid.moizaarchitecturesample.data.local.dao.PostDao
import com.moizaandroid.moizaarchitecturesample.data.local.entity.toResponse
import com.moizaandroid.moizaarchitecturesample.data.remote.dto.response.PostResponse
import javax.inject.Inject

class LocalPostDataSourceImpl @Inject constructor(
    private val postDao: PostDao
) : LocalPostDataSource {
    override suspend fun fetchPost(): PostResponse =
        postDao.fetchPost().toResponse()
}