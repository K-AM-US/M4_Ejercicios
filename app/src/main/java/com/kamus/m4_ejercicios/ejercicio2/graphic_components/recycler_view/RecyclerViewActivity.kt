package com.kamus.m4_ejercicios.ejercicio2.graphic_components.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kamus.m4_ejercicios.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewList)

        val rvData = RVAdapter(
            arrayListOf<Data>(
                Data("Mauricio", "Casillas", 24),
                Data("Noel", "Gallagher", 56),
                Data("Damon", "Albarn", 55),
                Data("Robert", "Del Naja", 58),
                Data("Thom", "Yorke", 54),
                Data("Richard", "Ashcroft", 51),
                Data("Jarvis", "Cocker", 59)
            )
        )

        recyclerView.adapter = rvData
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}