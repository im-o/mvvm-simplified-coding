package com.example.newmvvmsimplifiedcarakde.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newmvvmsimplifiedcarakde.data.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.data.repository.BaseRepository

/**
 * Created by rivaldy on Sep/18/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //add more when, when u add other view model
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("View Model Class Not Found")
        }
    }
}