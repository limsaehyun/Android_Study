package com.moizaandroid.moizaarchitecturesample.di.module

import com.moizaandroid.moizaarchitecturesample.data.local.datasource.LocalPostDataSource
import com.moizaandroid.moizaarchitecturesample.data.local.datasource.LocalPostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(
        localPostDataSourceImpl: LocalPostDataSourceImpl
    ): LocalPostDataSource
}