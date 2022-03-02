package com.saehyun.gsparchitectureexample.di.module

import com.saehyun.gsparchitectureexample.data.remote.datasource.RemotePostDataSource
import com.saehyun.gsparchitectureexample.data.remote.datasource.RemotePostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(
        remotePostDataSourceImpl: RemotePostDataSourceImpl
    ): RemotePostDataSource
}