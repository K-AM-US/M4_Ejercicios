package com.kamus.m4_ejercicios.tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kamus.m4_ejercicios.R
import com.kamus.m4_ejercicios.databinding.ActivityDatosBinding

class DatosActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if(bundle != null){
            binding.dataName.text = getString(R.string.greetings, bundle.getString("name", ""))
            binding.dataFullName.text = getString(R.string.fullname, bundle.getString("name",""), bundle.getString("lastname", ""))
            binding.dataGenre.text = getString(R.string.dataGenre, bundle.getString("genre", ""))
            binding.dataEmail.text = getString(R.string.dataEmail, bundle.getString("email", ""))
            binding.dataPassword.text = getString(R.string.dataPassword, bundle.getString("password", ""))
        }
    }
}