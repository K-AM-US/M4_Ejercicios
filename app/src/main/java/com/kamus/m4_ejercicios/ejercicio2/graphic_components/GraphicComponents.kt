package com.kamus.m4_ejercicios.ejercicio2.graphic_components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.kamus.m4_ejercicios.R

class GraphicComponents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphic_components)

        /*
                Spinner
         */

        val spinner = findViewById<Spinner>(R.id.spinner)
        val frameworks =
            arrayListOf<String>("React", "Vue", "Angular", "JQuery", "Svelte", "Backbone")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, frameworks)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@GraphicComponents, "Opción spinner: ${frameworks[p2]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@GraphicComponents, "No hay opción seleccionada", Toast.LENGTH_SHORT).show()
            }

        }

        /*
                Checkbox
         */

        val checkboxKotlin = findViewById<CheckBox>(R.id.cbKotlin)
        checkboxKotlin.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(this, "Kotlin: $b", Toast.LENGTH_SHORT).show()
        }
        val checkboxJs = findViewById<CheckBox>(R.id.cbJs)
        checkboxJs.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(this, "JavaScript: $b", Toast.LENGTH_SHORT).show()
        }
        val checkboxSwift = findViewById<CheckBox>(R.id.cbSwift)
        checkboxSwift.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(this, "Swift: $b", Toast.LENGTH_SHORT).show()
        }

        /*
                Radio Button
         */

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupPlatform)
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            val idPlatform = when(i){
                R.id.rAndroid -> "Android"
                R.id.rIos -> "iOS"
                R.id.rWeb -> "Web"
                R.id.rDesktop -> "Desktop"
                else -> ""
            }
            Toast.makeText(this, "La plataforma seleccionada es: $idPlatform", Toast.LENGTH_SHORT).show()
        }
    }

    fun imgOnclick(view: View) {
        Toast.makeText(this, "Hiciste click en un Image button", Toast.LENGTH_SHORT).show()
    }

    fun sendDataOnClick(view: View) {
        Toast.makeText(this, "Ejemplo de componentes gráficos completo!", Toast.LENGTH_SHORT).show()
    }
}