package com.kamus.m4_ejercicios.practica_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.kamus.m4_ejercicios.R
import com.kamus.m4_ejercicios.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if(bundle != null){
            binding.showDataEmail.text = resources.getString(R.string.usrEmail, bundle.getString("EMAIL", ""))
            binding.showDataPass.text = resources.getString(R.string.usrPass, bundle.getString("PASSWORD", ""))
            if(bundle.getString("NAME") == null){
                binding.showDataName.visibility = View.GONE
                binding.showDataLastName.visibility = View.GONE
                binding.showDataGenre.visibility = View.GONE
            }else{
                binding.showDataName.text = resources.getString(R.string.usrName, bundle.getString("NAME", ""))
                binding.showDataLastName.text = resources.getString(R.string.usrLastName, bundle.getString("LASTNAME", ""))
                binding.showDataGenre.text = resources.getString(R.string.usrGenre, bundle.getString("GENRE", ""))
            }
        }
    }
}