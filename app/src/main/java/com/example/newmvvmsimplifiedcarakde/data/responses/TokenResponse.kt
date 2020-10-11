package com.example.newmvvmsimplifiedcarakde.data.responses


import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("token")
    val userToken: String? = null
)