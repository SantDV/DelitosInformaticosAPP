package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.ui.MainActivityBot

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnQuees = findViewById<Button>(R.id.btnQuees)
        btnQuees.setOnClickListener {
            val intent = Intent(this, quees::class.java)
            startActivity(intent)
        }

        val btnDelitos = findViewById<Button>(R.id.btnDelitos)
        btnDelitos.setOnClickListener {
            val intent = Intent(this, DelitosYciberSeguridad::class.java)
            startActivity(intent)
        }

        val btnPrivacidad = findViewById<Button>(R.id.btnPrivacidad)
        btnPrivacidad.setOnClickListener {
            val intent = Intent(this, Privacidad::class.java)
            startActivity(intent)
        }

        val btnDocumentos = findViewById<Button>(R.id.btnDocumento)
        btnDocumentos.setOnClickListener {
            val intent = Intent(this, Documentos::class.java)
            startActivity(intent)
        }

        val btnDefensa = findViewById<Button>(R.id.btnDefensa)
        btnDefensa.setOnClickListener {
            val intent = Intent(this, DefensaConsumidor::class.java)
            startActivity(intent)
        }

        val btnMarcas = findViewById<Button>(R.id.btnMarcas)
        btnMarcas.setOnClickListener {
            val intent = Intent(this, Marcas::class.java)
            startActivity(intent)
        }

        val btnNombres = findViewById<Button>(R.id.btnNombres)
        btnNombres.setOnClickListener {
            val intent = Intent(this, Nombres::class.java)
            startActivity(intent)
        }

        val btnRegimen = findViewById<Button>(R.id.btnRegimen)
        btnRegimen.setOnClickListener {
            val intent = Intent(this, Regimen::class.java)
            startActivity(intent)
        }

        val btnMenu = findViewById<Button>(R.id.btnMenu)
        btnMenu.setOnClickListener {
            val intent = Intent(this, LinksInteres::class.java)
            startActivity(intent)
        }

        //ChatBot!
        val btnBot = findViewById<ImageView>(R.id.btnBot)
        btnBot.setOnClickListener {
            val intent = Intent(this, MainActivityBot::class.java)
            startActivity(intent)
        }

        val btnContacto = findViewById<Button>(R.id.btnContacto)
        btnContacto.setOnClickListener {
            val intent = Intent(this, WebContacto::class.java)
            startActivity(intent)
        }
    }


}