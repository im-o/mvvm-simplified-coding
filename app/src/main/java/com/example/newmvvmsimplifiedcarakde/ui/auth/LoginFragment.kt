package com.example.newmvvmsimplifiedcarakde.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newmvvmsimplifiedcarakde.R
import com.example.newmvvmsimplifiedcarakde.databinding.FragmentLoginBinding
import com.example.newmvvmsimplifiedcarakde.network.AuthApi
import com.example.newmvvmsimplifiedcarakde.repository.AuthRepository
import com.example.newmvvmsimplifiedcarakde.ui.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //here call function binding and viewModel: login etc.
    }

    override fun getViewModel(): Class<AuthViewModel>  = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
}
