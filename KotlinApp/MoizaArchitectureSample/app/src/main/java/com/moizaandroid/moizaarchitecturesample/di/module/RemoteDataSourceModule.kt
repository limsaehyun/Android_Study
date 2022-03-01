package com.moizaandroid.moizaarchitecturesample.di.module

import com.moizaandroid.moizaarchitecturesample.data.remote.datasource.RemotePostDataSource
import com.moizaandroid.moizaarchitecturesample.data.remote.datasource.RemotePostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(
        remotePostDataSourceImpl: RemotePostDataSourceImpl
    ): RemotePostDataSource
}