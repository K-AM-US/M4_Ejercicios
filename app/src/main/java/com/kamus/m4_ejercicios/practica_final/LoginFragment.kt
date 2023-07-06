package com.kamus.m4_ejercicios.practica_final

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.kamus.m4_ejercicios.R
import com.kamus.m4_ejercicios.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            if(binding.etLoginEmail.text.isEmpty())
                binding.etLoginEmail.error = resources.getString(R.string.blank)
            else if(binding.etLoginPassword.text.isEmpty())
                binding.etLoginPassword.error = resources.getString(R.string.blank)
            else{
                val intent = Intent(requireContext(), ShowDataActivity::class.java)
                val bundle = Bundle()

                bundle.putString("EMAIL", binding.etLoginEmail.text.toString())
                bundle.putString("PASSWORD", binding.etLoginPassword.text.toString())

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

        binding.tvRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fmLogin, RegisterFragment.newInstance())
                .addToBackStack("RegisterFragment")
                .commit()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}