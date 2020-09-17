package com.example.newmvvmsimplifiedcarakde.network

import okhttp3.ResponseBody

/**
 * Created by rivaldy on Sep/17/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

sealed class Resource<out T> {
    data class Success<out T>(val value: T): Resource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ): Resource<Nothing>()
}