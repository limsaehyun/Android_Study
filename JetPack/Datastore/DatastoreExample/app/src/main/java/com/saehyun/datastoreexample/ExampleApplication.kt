package com.saehyun.datastoreexample

import android.app.Application

class ExampleApplication : Application() {

    private lateinit var dataStore: DataStoreModule

    companion object {
        private lateinit var exampleApplication: ExampleApplication
        fun getInstance() : ExampleApplication = exampleApplication
    }

    override fun onCreate() {
        super.onCreate()

        exampleApplication = this
        dataStore = DataStoreModule(this)
    }

    fun getDataStore() : DataStoreModule = dataStore
}