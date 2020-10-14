package com.example.newmvvmsimplifiedcarakde.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newmvvmsimplifiedcarakde.data.network.Resource
import com.example.newmvvmsimplifiedcarakde.data.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.data.responses.LoginResponse
import kotlinx.coroutines.launch

/**
 * Created by rivaldy on Sep/18/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class AuthViewModel(
    private val repository: AuthRepository,
) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val tokenResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.login(email, password)
    }

    suspend fun saveAuthToken(token: String) {
        repository.saveAuthToken(token)
    }
}