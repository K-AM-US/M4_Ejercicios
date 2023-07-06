package com.kamus.m4_ejercicios.practica_final

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kamus.m4_ejercicios.R
import com.kamus.m4_ejercicios.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.btnRegister.setOnClickListener {
            sendDataOnClick(requireView())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }

    fun sendDataOnClick(view: View) {
        var genre = ""

        if(binding.etRegisterName.text.isEmpty()) {
            binding.etRegisterName.error = resources.getString(R.string.blank)
            return
        }
        if(binding.etRegisterLastName.text.isEmpty()) {
            binding.etRegisterLastName.error = resources.getString(R.string.blank)
            return
        }
        if(binding.etRegisterEmail.text.isEmpty()){
            binding.etRegisterEmail.error = resources.getString(R.string.blank)
            return
        }
        if(binding.etRegisterPassword.text.isEmpty()) {
            binding.etRegisterPassword.error = resources.getString(R.string.blank)
            return
        }
        if(binding.genreGroup.checkedRadioButtonId == -1) {
            Toast.makeText(requireContext(), R.string.noGenre, Toast.LENGTH_SHORT).show()
            return
        }else{
            genre = when(binding.genreGroup.checkedRadioButtonId) {
                R.id.genreM -> resources.getString(R.string.m)
                R.id.genreF -> resources.getString(R.string.f)
                else -> ""
            }
        }

        val intent = Intent(requireContext(), ShowDataActivity::class.java)
        val bundle = Bundle()

        bundle.putString("NAME", binding.etRegisterName.text.toString())
        bundle.putString("LASTNAME", binding.etRegisterLastName.text.toString())
        bundle.putString("EMAIL", binding.etRegisterEmail.text.toString())
        bundle.putString("PASSWORD", binding.etRegisterPassword.text.toString())
        bundle.putString("GENRE", genre)

        intent.putExtras(bundle)
        startActivity(intent)
    }
}