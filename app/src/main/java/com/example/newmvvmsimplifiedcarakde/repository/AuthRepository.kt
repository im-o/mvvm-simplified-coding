package com.example.newmvvmsimplifiedcarakde.repository

import com.example.newmvvmsimplifiedcarakde.network.AuthApi

/**
 * Created by rivaldy on Sep/17/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class AuthRepository(
    private val api: AuthApi
): BaseRepository() {
    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }
}