package com.example.misfinanzas.activities

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.misfinanzas.MainActivity
import com.example.misfinanzas.R

class Ingresos : AppCompatActivity() {

    private lateinit var rdNomina : RadioButton
    private lateinit var rdBeca : RadioButton
    private lateinit var rdFreelance : RadioButton
    private lateinit var rdExtras : RadioButton
    private lateinit var gpIngresos: RadioGroup

    private lateinit var btnGuardaIngreso : Button
    private lateinit var campoCantidadIngreso : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresos)

        //declaración de los componentes
        campoCantidadIngreso = findViewById(R.id.campoCantidadIngreso)
        rdNomina = findViewById(R.id.rdBtnNomina)
        rdBeca = findViewById(R.id.rdBtnBeca)
        rdFreelance = findViewById(R.id.rdBtnFreelance)
        rdExtras = findViewById(R.id.rdBtnExtras)
        gpIngresos = findViewById(R.id.gpIngresos)

        btnGuardaIngreso = findViewById(R.id.btnGuardarIngreso)

        btnGuardaIngreso.setOnClickListener {
            //valida radioButton seleccionado
            if(gpIngresos.checkedRadioButtonId == -1){
                val t = Toast.makeText(this, "Selecciona una categoría", Toast.LENGTH_SHORT)
                t.setGravity(Gravity.CENTER, 0, 0)
                t.show()
            } else {
                guardarIngreso()
            }
        }
    }

    private fun guardarIngreso(){
        var cantNomina = 0.00f
        var cantBeca = 0.00f
        var cantFreelance = 0.00f
        var cantExtras = 0.00f
        val cantIngreso =  campoCantidadIngreso.text.toString()

        //valida campo con texto
        if(cantIngreso.isEmpty()) {
            campoCantidadIngreso.error = "Escribe la cantidad"
            return
        }

        var floatIngreso: Float = cantIngreso.toFloat()
        //operaciones para cada categoría
        if (rdNomina.isChecked) {
            floatIngreso += cantNomina
            cantNomina += cantNomina
            val texto = floatIngreso.toString()
            val t = Toast.makeText(this, "Tienes $texto pesos más", Toast.LENGTH_SHORT)
            t.setGravity(Gravity.CENTER, 0, 0)
            t.show()
        }
        if (rdBeca.isChecked) {
            floatIngreso += cantBeca
            cantBeca += cantBeca
            val texto = floatIngreso.toString()
            Toast.makeText(
                this,
                "Tienes $texto pesos más",
                Toast.LENGTH_SHORT
            ).show()
        }
        if (rdFreelance.isChecked) {
            floatIngreso += cantFreelance
            cantFreelance += cantFreelance
            val texto = floatIngreso.toString()
            Toast.makeText(this, "Tienes $texto pesos más", Toast.LENGTH_SHORT).show()
        }
        if (rdExtras.isChecked) {
            floatIngreso += cantExtras
            cantExtras += cantExtras
            val texto = floatIngreso.toString()
            Toast.makeText(this, "Tienes $texto pesos más", Toast.LENGTH_SHORT).show()
        }

        val redireccionamiento = Intent(this, MainActivity::class.java)
        startActivity(redireccionamiento)
        finish()
    }
}