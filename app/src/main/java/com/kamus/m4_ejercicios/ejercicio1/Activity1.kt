package com.kamus.m4_ejercicios.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.kamus.m4_ejercicios.R

class Activity1 : AppCompatActivity() {

    private val register =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK)
                Toast.makeText(
                    this,
                    "resultCode = ${it.resultCode} EXTRA_IS_OK = ${
                        it.data?.getBooleanExtra(
                            "EXTRA_IS_OK",
                            false
                        )

                    }\nName: ${it.data?.getStringExtra("EXTRA_NAME")} \nLast name: ${
                        it.data?.getStringExtra(
                            "EXTRA_LASTNAME"
                        )
                    } \nAge: ${
                        it.data?.getIntExtra(
                            "EXTRA_AGE",
                            0
                        )
                    } \nGames: ${it.data?.getStringArrayListExtra("EXTRA_GAMES")}",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(this, "result = ${it.resultCode} - CANCELLED", Toast.LENGTH_LONG)
                    .show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val btnToActivity2 = findViewById<Button>(R.id.btnActivity2)
        btnToActivity2.setOnClickListener {
            val sendData = Intent(this, Activity2::class.java).apply {
                putExtra("EXTRA_NAME", "Mauricio")
                putExtra("EXTRA_LASTNAME", "Casillas")
                putExtra("EXTRA_AGE", 24)
                putExtra(
                    "EXTRA_GAMES",
                    arrayListOf("Destiny", "Elden Ring", "Diablo", "Halo", "Monster Hunter")
                )
            }
            register.launch(sendData)
        }
    }
}