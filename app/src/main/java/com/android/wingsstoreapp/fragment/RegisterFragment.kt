package com.android.wingsstoreapp.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.common.BaseFragment
import com.android.common.entity.LoginEntity
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.RegisterLayoutBinding
import com.android.wingsstoreapp.view_model.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment: BaseFragment<RegisterViewModel, RegisterLayoutBinding>() {
    override val vm: RegisterViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.register_layout

    override fun initBinding(binding: RegisterLayoutBinding) {
        super.initBinding(binding)

        binding.btnRegister.setOnClickListener {
            vm.register(LoginEntity(binding.txtUsername.text.toString(), binding.txtPassword.text.toString()))
            Toast.makeText(this.context, "Success Register",1).show()
            findNavController().popBackStack()
        }
    }
}