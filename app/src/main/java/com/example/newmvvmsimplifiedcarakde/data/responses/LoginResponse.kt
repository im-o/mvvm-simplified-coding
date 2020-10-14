package com.example.newmvvmsimplifiedcarakde.data.responses


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("user")
    val user: User? = null
)