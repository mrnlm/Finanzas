package com.example.misfinanzas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.misfinanzas.activities.Detalles
import com.example.misfinanzas.activities.Egresos
import com.example.misfinanzas.activities.Ingresos

class MainActivity : AppCompatActivity() {

    private lateinit var botonIngresos : Button
    private lateinit var botonEgresos : Button
    private lateinit var botonDetalles : Button
    private lateinit var txtIngresos: TextView
    private lateinit var txtEgresos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonIngresos = findViewById(R.id.btnAgregarIngreso)
        botonEgresos = findViewById(R.id.btnAgregarEgreso)
        botonDetalles = findViewById(R.id.btnDetalles)
        txtIngresos = findViewById(R.id.valueIngresos)
        txtEgresos = findViewById(R.id.valueEgresos)

        //lanza activity de agregar ingreso
        botonIngresos.setOnClickListener{
            val intentIn = Intent(this, Ingresos::class.java)
            startActivity(intentIn)
        }

        //lanza activity de agregar ingreso
        botonEgresos.setOnClickListener{
            val intentEg = Intent(this, Egresos::class.java)
            startActivity(intentEg)
        }

        //lanza activity de detalles
        botonDetalles.setOnClickListener {
            val intentDe = Intent(this, Detalles::class.java)
            startActivity(intentDe)
        }
    }
}