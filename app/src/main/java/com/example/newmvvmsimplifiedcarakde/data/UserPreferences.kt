package com.example.newmvvmsimplifiedcarakde.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by rivaldy on Oct/07/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class UserPreferences(
    context: Context
) {
    companion object {
        private const val DATA_STORE_NAME = "user_data_store"
        private val KEY_AUTH = preferencesKey<String>("key_auth")
    }

    private val appContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = appContext.createDataStore(
            name = DATA_STORE_NAME
        )
    }

    val authToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[KEY_AUTH]
        }

    suspend fun saveAuthToken(authToken: String) {
        dataStore.edit { preferences ->
            preferences[KEY_AUTH] = authToken
        }
    }
}