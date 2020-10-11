package com.example.newmvvmsimplifiedcarakde.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.newmvvmsimplifiedcarakde.R
import com.example.newmvvmsimplifiedcarakde.databinding.FragmentLoginBinding
import com.example.newmvvmsimplifiedcarakde.data.network.AuthApi
import com.example.newmvvmsimplifiedcarakde.data.network.Resource
import com.example.newmvvmsimplifiedcarakde.data.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.ui.base.BaseFragment
import com.example.newmvvmsimplifiedcarakde.utils.gone
import com.example.newmvvmsimplifiedcarakde.utils.myToast
import com.example.newmvvmsimplifiedcarakde.utils.visible
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //@todo here call function binding and viewModel
        viewModel.tokenResponse.observe(viewLifecycleOwner, Observer {
            binding.loginProgressPB.gone()
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        userPreferences.saveAuthToken(it.value.userToken.toString())
                    }
                    requireContext().myToast("${getString(R.string.login_success)} $it")
                }
                is Resource.Failure -> {
                    requireContext().myToast("${getString(R.string.login_failure)} $it")
                }
            }
        })
        binding.loginMB.setOnClickListener {
            //@todo add input validations
            binding.loginProgressPB.visible()
            val email = binding.userEmailET.text.toString().trim()
            val password = binding.userPassET.text.toString().trim()
            viewModel.login(email, password)
        }
    }

    override fun getViewModel(): Class<AuthViewModel> = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
}
