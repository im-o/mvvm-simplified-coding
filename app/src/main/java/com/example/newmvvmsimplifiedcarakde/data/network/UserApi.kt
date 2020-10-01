package com.example.newmvvmsimplifiedcarakde.data.network

import com.example.newmvvmsimplifiedcarakde.data.responses.LoginResponse
import retrofit2.http.GET

/**
 * Created by rivaldy on Oct/14/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface UserApi {

    @GET("user")
    suspend fun getUser(): LoginResponse
}