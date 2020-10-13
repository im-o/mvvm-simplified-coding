package com.example.newmvvmsimplifiedcarakde.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.newmvvmsimplifiedcarakde.R
import com.example.newmvvmsimplifiedcarakde.data.network.AuthApi
import com.example.newmvvmsimplifiedcarakde.data.network.Resource
import com.example.newmvvmsimplifiedcarakde.data.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.databinding.FragmentLoginBinding
import com.example.newmvvmsimplifiedcarakde.ui.base.BaseFragment
import com.example.newmvvmsimplifiedcarakde.ui.home.HomeActivity
import com.example.newmvvmsimplifiedcarakde.utils.*
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        editTextListener(binding.userEmailET)
        editTextListener(binding.userPassET)
        viewModel.tokenResponse.observe(viewLifecycleOwner, {
            binding.loginProgressPB.gone()
            when (it) {
                is Resource.Success -> {
                    viewModel.saveAuthToken(it.value.userToken.toString())
                    requireContext().myToast("${getString(R.string.login_success)} $it")
                    requireContext().startNewActivity(HomeActivity::class.java)
                }
                is Resource.Failure -> {
                    requireContext().myToast("${getString(R.string.login_failure)} $it")
                }
            }
        })

        binding.loginMB.setOnClickListener {
            val email = binding.userEmailET.text.toString().trim()
            val password = binding.userPassET.text.toString().trim()
            binding.loginProgressPB.visible()
            viewModel.login(email, password)
        }
    }

    private fun editTextListener(editText: TextInputEditText) {
        editText.addTextChangedListener {
            val email = binding.userEmailET.text.toString().trim()
            val password = binding.userPassET.text.toString().trim()
            binding.loginMB.enable(email.isNotEmpty() && password.isNotEmpty())
        }
    }

    override fun getViewModel(): Class<AuthViewModel> = AuthViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?)
            : FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences)
}
