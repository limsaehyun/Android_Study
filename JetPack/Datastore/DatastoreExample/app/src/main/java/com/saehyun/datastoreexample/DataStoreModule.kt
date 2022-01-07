package com.saehyun.datastoreexample

import android.content.Context
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreModule(private val context : Context) {

    private val Context.dataStore  by preferencesDataStore(name = "dataStore")

    private val stringKey = stringPreferencesKey("textKey")

    val text : Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {preferences ->
            preferences[stringKey] ?: ""
        }

    suspend fun setText(text : String){
        context.dataStore.edit { preferences ->
            preferences[stringKey] = text
        }
    }

}