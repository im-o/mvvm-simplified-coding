package com.example.newmvvmsimplifiedcarakde.responses


import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("token")
    val userToken: String? = null
)