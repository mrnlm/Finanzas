package com.example.misfinanzas.activities

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.misfinanzas.MainActivity
import com.example.misfinanzas.R

class Egresos: AppCompatActivity() {

    private lateinit var rdAlimentacion: RadioButton
    private lateinit var rdCuidadoPersonal: RadioButton
    private lateinit var rdEntretenimiento: RadioButton
    private lateinit var rdImpuestos: RadioButton
    private lateinit var rdIndumentaria: RadioButton
    private lateinit var rdLimpieza: RadioButton
    private lateinit var rdSalud: RadioButton
    private lateinit var rdServicios: RadioButton
    private lateinit var rdViaticos: RadioButton
    private lateinit var rdVivienda: RadioButton
    private lateinit var rdOtros: RadioButton
    private lateinit var gpEgresos: RadioGroup

    private lateinit var btnGuardaEgreso: Button
    private lateinit var campoCantidadEgreso: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egresos)

        //declaración de los componentes
        campoCantidadEgreso = findViewById(R.id.campoCantidadEgreso)
        rdAlimentacion = findViewById(R.id.rdBtnAlimentacion)
        rdCuidadoPersonal = findViewById(R.id.rdBtnCuidadoPersonal)
        rdEntretenimiento = findViewById(R.id.rdBtnEntretenimiento)
        rdImpuestos = findViewById(R.id.rdBtnImpuestos)
        rdIndumentaria = findViewById(R.id.rdBtnIndumentaria)
        rdLimpieza = findViewById(R.id.rdBtnLimpieza)
        rdSalud = findViewById(R.id.rdBtnSalud)
        rdServicios = findViewById(R.id.rdBtnServicios)
        rdViaticos = findViewById(R.id.rdBtnViaticos)
        rdVivienda = findViewById(R.id.rdBtnVivienda)
        rdOtros = findViewById(R.id.rdBtnOtros)
        gpEgresos = findViewById(R.id.gpEgresos)

        btnGuardaEgreso = findViewById(R.id.btnGuardarEgreso)

        btnGuardaEgreso.setOnClickListener {
            //valida radioButton seleccionado
            if (gpEgresos.checkedRadioButtonId == -1) {
                val t = Toast.makeText(this, "Selecciona una categoría", Toast.LENGTH_SHORT)
                t.setGravity(Gravity.CENTER, 0, 0)
                t.show()
            } else {
                 guardarEgreso()
            }
        }
    }

    private fun guardarEgreso(){
        var cantAlimentacion = 0.00f
        var cantCuidadoPersonal = 0.00f
        var cantEntretenimiento = 0.00f
        var cantImpuestos = 0.00f
        var cantIndumentaria = 0.00f
        var cantLimpieza = 0.00f
        var cantSalud = 0.00f
        var cantServicios = 0.00f
        var cantViaticos = 0.00f
        var cantVivienda = 0.00f
        var cantOtros = 0.00f
        val cantEgreso =  campoCantidadEgreso.text.toString()

        if(cantEgreso.isEmpty()){
            campoCantidadEgreso.error = "Escribe la cantidad"
            return
        }

        var floatEgreso: Float = cantEgreso.toFloat()
        //operaciones para cada categoría
        if(rdAlimentacion.isChecked){

        }


        val redireccionamiento = Intent(this, MainActivity::class.java)
        startActivity(redireccionamiento)
        finish()
    }
}