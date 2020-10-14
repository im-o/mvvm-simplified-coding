package com.example.newmvvmsimplifiedcarakde.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newmvvmsimplifiedcarakde.data.network.Resource
import com.example.newmvvmsimplifiedcarakde.data.network.UserApi
import com.example.newmvvmsimplifiedcarakde.data.repository.UserRepository
import com.example.newmvvmsimplifiedcarakde.data.responses.User
import com.example.newmvvmsimplifiedcarakde.databinding.FragmentHomeBinding
import com.example.newmvvmsimplifiedcarakde.ui.base.BaseFragment
import com.example.newmvvmsimplifiedcarakde.utils.visible
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, UserRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingProgress.visible(false)
        viewModel.getUser()
        viewModel.user.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    binding.loadingProgress.visible(false)
                    updateUI(it.value.user)
                }

                is Resource.Loading -> {
                    binding.loadingProgress.visible(true)
                }
            }
        })
    }

    private fun updateUI(user: User?) {
        with(binding) {
            val userResult = "ID : ${user?.id}\nName : ${user?.name}\nEmail : ${user?.email}"
            resultTV.text = userResult
        }
    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): UserRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(UserApi::class.java, token)
        return UserRepository(api)
    }
}