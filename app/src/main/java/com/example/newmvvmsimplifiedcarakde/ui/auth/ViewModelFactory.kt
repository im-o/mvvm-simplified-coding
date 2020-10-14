package com.example.newmvvmsimplifiedcarakde.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newmvvmsimplifiedcarakde.data.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.data.repository.BaseRepository
import com.example.newmvvmsimplifiedcarakde.data.repository.UserRepository
import com.example.newmvvmsimplifiedcarakde.ui.home.HomeViewModel

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
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("View Model Class Not Found")
        }
    }
}