package com.example.helloworld.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.helloworld.detalle.MainActivity
import com.example.helloworld.R
import com.google.android.material.textfield.TextInputEditText


class RegistroSuperheroeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_superheroe)

        val registrarBoton:Button = findViewById(R.id.registrar_boton)
        val nombreEditText:EditText = findViewById(R.id.nombre_edit_text)
        val nombreTextView:TextView = findViewById(R.id.textView5)
        val estaturaEditText:TextInputEditText = findViewById(R.id.estatura_edit_text)
        val masculinoRadioButon:RadioButton = findViewById(R.id.masculino_radio_boton)
        //val femeninoRadioButon:RadioButton = findViewById(R.id.femenino_radio_buton) no se esta utilizando
        val superfuerzaCheckBox:CheckBox = findViewById(R.id.super_fuerza_checkbox)
        val superVelocidadCheckBox:CheckBox = findViewById(R.id.super_velocidad_checkbox)
        val telequenesisCheckBox:CheckBox = findViewById(R.id.telequenesis_checkbox)
        val ciudadNacimientoSpiner:Spinner = findViewById(R.id.ciudad_nacimiento_spinner)

        registrarBoton.setOnClickListener {
            if(nombreEditText.text.toString()== "" || estaturaEditText.text.toString() == "" )
                Toast.makeText(this,"Debe digitar el nombre y la estatura",Toast.LENGTH_SHORT).show()
            else{
                val nombre:String = nombreEditText.text.toString()
                val estatura:Float = estaturaEditText.text.toString().toFloat()
                var poderes = ""
                val ciudadNacimiento:String = ciudadNacimientoSpiner.selectedItem.toString()
                val genero:String = if(masculinoRadioButon.isChecked)
                    getString(R.string.masculino)
                else
                    getString(R.string.femenino)
                if (superfuerzaCheckBox.isChecked)
                    poderes = getString(R.string.super_fuerza)
                if (superVelocidadCheckBox.isChecked)
                    poderes += " " + getString(R.string.super_velocidad)
                if (telequenesisCheckBox.isChecked)
                    poderes += " " + getString(R.string.telequenesis)

                nombreTextView.text = getString(R.string.info, nombre, estatura, genero, poderes, ciudadNacimiento)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
    override fun onStop() {
        super.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onRestart() {
        super.onRestart()
    }
}