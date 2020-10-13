package com.example.newmvvmsimplifiedcarakde.data.repository

import com.example.newmvvmsimplifiedcarakde.data.UserPreferences
import com.example.newmvvmsimplifiedcarakde.data.network.AuthApi

/**
 * Created by rivaldy on Sep/17/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository() {

    suspend fun login(email: String, password: String) = safeApiCall {
        api.login(email, password)
    }

    suspend fun saveAuthToken(token: String){
        preferences.saveAuthToken(token)
    }
}