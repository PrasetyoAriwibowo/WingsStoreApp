package com.android.wingsstoreapp.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.common.BaseFragment
import com.android.common.ResponseLoading
import com.android.common.ResponseSuccess
import com.android.common.entity.LoginEntity
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.LoginLayoutBinding
import com.android.wingsstoreapp.view_model.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, LoginLayoutBinding>() {
    override val vm: LoginViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.login_layout

    override fun initBinding(binding: LoginLayoutBinding) {
        super.initBinding(binding)
        vm.loginData?.observe(viewLifecycleOwner){
            when(it){
                is ResponseSuccess -> {
                    Toast.makeText(this.context, "Success Login",1).show()
                    findNavController().navigate(
                        LoginFragmentDirections.loginFragmentToProductFragment()
                    )
                }
                is ResponseLoading -> Toast.makeText(this .context, "Please Wait", 1).show()
                else -> {
                    Toast.makeText(this.context, "Error", 1).show()
                }
            }
        }

        binding.btnLogin.setOnClickListener {
            vm.login(
                LoginEntity(
                    binding.txtUsername.text.toString(),
                    binding.txtPassword.text.toString()
                )
            )
        }

        binding.txtRegister.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.loginFragmentToRegisterFragment())
        }
    }
}