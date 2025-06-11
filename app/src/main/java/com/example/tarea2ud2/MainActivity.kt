package com.example.tarea2ud2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val switchModoOscuro: Switch = findViewById(R.id.switchModoOscuro)
        val textViewModo: TextView = findViewById(R.id.textViewModo)


        switchModoOscuro.setOnCheckedChangeListener { _, isSelected ->
            if (isSelected) {
                textViewModo.text = "Modo oscuro activado"
                enableDarkMode()
            } else {
                textViewModo.text = "Modo oscuro desactivado"
                disableDarkMode()
            }
        }
    }
        private fun enableDarkMode() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        private fun disableDarkMode() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


    fun botonSaludo(view: View) {
        val editText = findViewById<EditText>(R.id.respuestaNombre)
        val nombre = editText.text.toString()

        if (nombre.isNotEmpty()) {
            try {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Saludo")
                    .setMessage("¡Hola, $nombre!")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                builder.create().show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al mostrar el saludo", Toast.LENGTH_SHORT).show()
            }
        } else {
           Toast.makeText(this, "Por favor, ingresa tu nombre", Toast.LENGTH_SHORT).show()
        }
    }
}
