package com.exam.lista_de_la_compra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Spinner

class FormularioActivity : AppCompatActivity() {
    lateinit var rb_5: RadioButton
    lateinit var rb_4: RadioButton
    lateinit var rb_3: RadioButton
    lateinit var rb_2: RadioButton
    lateinit var rb_1: RadioButton
    lateinit var cb_lacteos: CheckBox
    lateinit var cb_carnes: CheckBox
    lateinit var cb_verduras: CheckBox
    lateinit var cb_frutas: CheckBox
    lateinit var cb_embasados: CheckBox
    lateinit var cb_panaderia: CheckBox
    lateinit var rating: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val spinner: Spinner = findViewById(R.id.spinner_age)
        rb_5 = findViewById<RadioButton>(R.id.rb_5)
        rb_4 = findViewById<RadioButton>(R.id.rb_4)
        rb_3 = findViewById<RadioButton>(R.id.rb_3)
        rb_2 = findViewById<RadioButton>(R.id.rb_2)
        rb_1 = findViewById<RadioButton>(R.id.rb_1)
        cb_lacteos = findViewById<CheckBox>(R.id.cb_lacteos)
        cb_carnes = findViewById<CheckBox>(R.id.cb_carnes)
        cb_verduras = findViewById<CheckBox>(R.id.cb_verduras)
        cb_frutas = findViewById<CheckBox>(R.id.cb_frutas)
        cb_embasados = findViewById<CheckBox>(R.id.cb_embasados)
        cb_panaderia = findViewById<CheckBox>(R.id.cb_panaderia)
        val butSend = findViewById<Button>(R.id.but_send)
        ArrayAdapter.createFromResource(
            this,
            R.array.ages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        rb_5.setOnClickListener{
            rating = "5"
        }
        rb_4.setOnClickListener{
            rating = "4"
        }
        rb_3.setOnClickListener{
            rating = "3"
        }
        rb_2.setOnClickListener{
            rating = "2"
        }
        rb_1.setOnClickListener{
            rating = "1"
        }
    }
}