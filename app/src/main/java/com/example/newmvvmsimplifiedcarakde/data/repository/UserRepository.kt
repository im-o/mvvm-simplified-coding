package com.example.newmvvmsimplifiedcarakde.data.repository

import com.example.newmvvmsimplifiedcarakde.data.network.UserApi

/**
 * Created by rivaldy on Sep/17/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class UserRepository(
    private val api: UserApi,
) : BaseRepository() {

    suspend fun getUser() = safeApiCall {
        api.getUser()
    }
}