package com.kamus.m4_ejercicios.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kamus.m4_ejercicios.R

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastname = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val games = intent.getStringArrayListExtra("EXTRA_GAMES")

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvGames = findViewById<TextView>(R.id.tvGames)

        tvName.text = name
        tvLastName.text = lastname
        tvAge.text = age.toString()
        tvGames.text = games.toString()

        val btnActivity1 = findViewById<Button>(R.id.btnActivity1)
        btnActivity1.setOnClickListener {
            val intentBackData = Intent().apply {
                putExtra("EXTRA_IS_OK", true)
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_LASTNAME", lastname)
                putExtra("EXTRA_AGE", age)
                putExtra("EXTRA_GAMES", games)
            }
            setResult(RESULT_OK, intentBackData)
            finish()
        }
    }
}