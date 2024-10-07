package com.example.tiendaderopa10

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mail: EditText
    private lateinit var password: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mail = findViewById(R.id.edtEmail)
        password = findViewById(R.id.edtContraseña)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)
    }

    fun onClick(view: View?){
        when(view?.id){
            R.id.btnIngresar -> ingresarMenu()
            R.id.btnSalir -> salir()
        }
    }

    private fun ingresarMenu(){
        val usr = mail.text.toString().trim()
        val con = password.text.toString().trim()

        if (usr == "admin" && con == "1234"){
            val intent = Intent(this, MenuLateralActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Datos incorrectos, intenta de nuevo.", Toast.LENGTH_LONG).show()
        }
    }

    private fun salir(){
        salir()
    }
}