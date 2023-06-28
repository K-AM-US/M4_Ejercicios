package com.kamus.m4_ejercicios.tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.kamus.m4_ejercicios.R
import com.kamus.m4_ejercicios.databinding.ActivityRegistroAppBinding

class RegistroAppActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistroAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun sendDataOnClick(view: View) {
        val bundle = Bundle()
        val intent = Intent(this, DatosActivity::class.java)
        var genre = ""

        if(binding.etNameForm.text.isEmpty()) {
            binding.etNameForm.setError(resources.getString(R.string.blank))
            return
        }

        if(binding.etLastNameForm.text.isEmpty()) {
            binding.etLastNameForm.setError(resources.getString(R.string.blank))
            return
        }
        
        if(binding.etEmail.text.isEmpty()) {
            binding.etEmail.setError(resources.getString(R.string.blank))
            return
        }

        if(binding.etPassword.text.isEmpty()) {
            binding.etPassword.setError(resources.getString(R.string.blank))
            return
        }

        if(binding.etNameForm.text.isEmpty()) {
            binding.etNameForm.setError(resources.getString(R.string.blank))
            return
        }

        if(binding.genreGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, R.string.noGenre, Toast.LENGTH_SHORT).show()
            return
        }else{
            genre = when(binding.genreGroup.checkedRadioButtonId) {
                R.id.genreM -> resources.getString(R.string.m)
                R.id.genreF -> resources.getString(R.string.f)
                else -> ""
            }
        }

        bundle.putString("name", binding.etNameForm.text.toString())
        bundle.putString("lastname", binding.etLastNameForm.text.toString())
        bundle.putString("genre", genre)
        bundle.putString("email",binding.etEmail.text.toString())
        bundle.putString("password", binding.etPassword.text.toString())

        intent.putExtras(bundle)
        startActivity(intent)
    }
}