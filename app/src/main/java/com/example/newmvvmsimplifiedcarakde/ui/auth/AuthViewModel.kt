package com.example.newmvvmsimplifiedcarakde.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newmvvmsimplifiedcarakde.data.network.Resource
import com.example.newmvvmsimplifiedcarakde.data.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.data.responses.TokenResponse
import kotlinx.coroutines.launch

/**
 * Created by rivaldy on Sep/18/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _tokenResponse: MutableLiveData<Resource<TokenResponse>> = MutableLiveData()
    val tokenResponse: LiveData<Resource<TokenResponse>>
        get() = _tokenResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _tokenResponse.value = repository.login(email, password)
    }
}