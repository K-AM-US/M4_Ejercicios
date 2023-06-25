package com.kamus.m4_ejercicios.ejercicio1.implicit_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kamus.m4_ejercicios.R

class ImplicitIntentUrl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_url)

        val btnUrl = findViewById<Button>(R.id.btnImplicitIntent)

        btnUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))
            startActivity(urlIntent)
        }
    }
}