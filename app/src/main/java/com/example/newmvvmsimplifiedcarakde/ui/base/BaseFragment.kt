package com.example.newmvvmsimplifiedcarakde.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.newmvvmsimplifiedcarakde.data.UserPreferences

import com.example.newmvvmsimplifiedcarakde.data.network.RemoteDataSource
import com.example.newmvvmsimplifiedcarakde.data.repository.BaseRepository
import com.example.newmvvmsimplifiedcarakde.ui.auth.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 */

abstract class BaseFragment<VM: ViewModel, B:  ViewBinding, R: BaseRepository> : Fragment(){

    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userPreferences = UserPreferences(requireContext())
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory)[getViewModel()]
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFragmentRepository(): R
}
