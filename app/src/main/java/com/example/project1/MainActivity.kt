package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.lang.Math.cos
import java.lang.Math.log10
import java.lang.Math.sin
import java.lang.Math.tan
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException
import kotlin.math.ln

class MainActivity : AppCompatActivity() {
    lateinit var b1: android.widget.Button
    lateinit var b2: android.widget.Button
    lateinit var b3: android.widget.Button
    lateinit var b4: android.widget.Button
    lateinit var b5: android.widget.Button
    lateinit var b6: android.widget.Button
    lateinit var b7: android.widget.Button
    lateinit var b8: android.widget.Button
    lateinit var b9: android.widget.Button
    lateinit var b0: android.widget.Button
    lateinit var b00: android.widget.Button
    lateinit var bclear: android.widget.Button
    lateinit var badd: android.widget.Button
    lateinit var bpercent: android.widget.Button
    lateinit var bdivide: android.widget.Button
    lateinit var bmultiply: android.widget.Button
    lateinit var bminus: android.widget.Button
    lateinit var bplus: android.widget.Button
    lateinit var bequal: android.widget.Button
    lateinit var bdecimal: android.widget.Button
    lateinit var inputtex: EditText
    lateinit var resulttex: EditText
    var bsin: android.widget.Button? = null
    var bcos: android.widget.Button? = null
    var btan: android.widget.Button? = null
    var blog10: android.widget.Button? = null
    var bln: android.widget.Button? = null

    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        b1 = findViewById(R.id.b1) // calling all the buttons
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        b0 = findViewById(R.id.b0)
        b00 = findViewById(R.id.b00)
        bclear = findViewById(R.id.bclear)
        badd = findViewById(R.id.badd)
        bpercent = findViewById(R.id.bpercent)
        bdivide = findViewById(R.id.bdivide)
        bmultiply = findViewById(R.id.bmultiply)
        bminus = findViewById(R.id.bminus)
        bplus = findViewById(R.id.bplus)
        bequal = findViewById(R.id.bequal)
        bdecimal = findViewById(R.id.bdecimal)
        resulttex = findViewById(R.id.result)
        inputtex = findViewById(R.id.inputnumber)
        bsin = findViewById(R.id.bsin)
        bcos = findViewById(R.id.bcos)
        btan = findViewById(R.id.btan)
        blog10 = findViewById(R.id.blog10)
        bln = findViewById(R.id.bln)
        inputtex.movementMethod = ScrollingMovementMethod()
        inputtex.setActivated(true)
        inputtex.setPressed(true)

        var text: String

        // Check orientation and reset input if it's a configuration change
        if (savedInstanceState != null) {
            val savedInput = savedInstanceState.getString("input")
            inputtex.setText(savedInput)
            if (savedInput != null) {
                result(savedInput)
            }
        }


        // concatenating the corresponding button numbers
        b1.setOnClickListener {
            text = inputtex.text.toString()+"1"
            inputtex.setText(text)
            result(text)
        }

        b2.setOnClickListener {
            text = inputtex.text.toString()+"2"
            inputtex.setText(text)
            result(text)
        }

        b3.setOnClickListener {
            text = inputtex.text.toString()+"3"
            inputtex.setText(text)
            result(text)
        }

        b4.setOnClickListener {
            text = inputtex.text.toString()+"4"
            inputtex.setText(text)
            result(text)
        }

        b5.setOnClickListener {
            text = inputtex.text.toString()+"5"
            inputtex.setText(text)
            result(text)
        }

        b6.setOnClickListener {
            text = inputtex.text.toString()+"6"
            inputtex.setText(text)
            result(text)
        }

        b7.setOnClickListener {
            text = inputtex.text.toString()+"7"
            inputtex.setText(text)
            result(text)
        }

        b8.setOnClickListener {
            text = inputtex.text.toString()+"8"
            inputtex.setText(text)
            result(text)
        }

        b9.setOnClickListener {
            text = inputtex.text.toString()+"9"
            inputtex.setText(text)
            result(text)
        }

        b0.setOnClickListener {
            text = inputtex.text.toString()+"0"
            inputtex.setText(text)
            result(text)
        }

        b00.setOnClickListener {
            text = inputtex.text.toString()+"00"
            inputtex.setText(text)
            result(text)
        }

        bdecimal.setOnClickListener {
            text = inputtex.text.toString()+"."
            inputtex.setText(text)
            result(text)
        }


        /**
         * jsdjsk
         */

        // reiterate for the -
        var isNegative = false

        badd.setOnClickListener {
            val currentTest = inputtex.text.toString()
            if (currentTest.isNotEmpty() && currentTest.toDoubleOrNull() != null) {
                val number = currentTest.toDouble()
                val result = if (isNegative) -number else number
                inputtex.setText(result.toString())
                isNegative = !isNegative
            }
        }

        bplus.setOnClickListener {
            text = inputtex.text.toString()+"+"
            inputtex.setText(text)
            check = check + 1
        }

        bdivide.setOnClickListener {
            text = inputtex.text.toString()+"/"
            inputtex.setText(text)
            check = check + 1
        }

        bminus.setOnClickListener {
            text = inputtex.text.toString()+"-"
            inputtex.setText(text)
            check = check + 1
        }

        bpercent.setOnClickListener {
            text = inputtex.text.toString()+"%"
            inputtex.setText(text)
            check = check + 1
        }

        bmultiply.setOnClickListener {
            text = inputtex.text.toString()+"*"
            inputtex.setText(text)
            check = check + 1
        }

        bequal.setOnClickListener {
            text= resulttex.text.toString()
            inputtex.setText(text)
            resulttex.setText(null)
        }

        bclear.setOnClickListener {
            inputtex.setText(null)
            resulttex.setText(null)
        }

        bsin?.setOnClickListener {
            val input = inputtex.text.toString()
            try {
                val inputDouble = input.toDouble()
                val result = sin(inputDouble)
                inputtex.setText(result.toString())
                resulttex.setText(null)

                // Log the button click
                Log.d("Button Click", "sin button clicked")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        bcos?.setOnClickListener {
            val input = inputtex.text.toString()
            try {
                val inputDouble = input.toDouble()
                val result = cos(inputDouble)
                inputtex.setText(result.toString())
                resulttex.setText(null)

                // Log the button click
                Log.d("Button Click", "cos button clicked")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        btan?.setOnClickListener {
            val input = inputtex.text.toString()
            try {
                val inputDouble = input.toDouble()
                val result = tan(inputDouble)
                inputtex.setText(result.toString())
                resulttex.setText(null)

                // Log the button click
                Log.d("Button Click", "tan button clicked")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        blog10?.setOnClickListener {
            val input = inputtex.text.toString()
            try {
                val inputDouble = input.toDouble()
                val result = log10(inputDouble)
                inputtex.setText(result.toString())
                resulttex.setText(null)

                // Log the button click
                Log.d("Button Click", "log10 button clicked")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        bln?.setOnClickListener {
            val input = inputtex.text.toString()
            try {
                val inputDouble = input.toDouble()
                val result = ln(inputDouble)
                inputtex.setText(result.toString())
                resulttex.setText(null)

                // Log the button click
                Log.d("Button Click", "ln button clicked")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("input", inputtex.text.toString())
    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        // Handle configuration change here if needed
//    }



    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino") //build gradle
        try {
            val result: Any = engine.eval(text)
            var mainres = result.toString()
            if(check == 0)
            {
                resulttex.setText(null)
            }
            else
            {
                resulttex.setText(mainres)
            }
        }

        catch (e: ScriptException)
        {
            Log.d("TAG", "ERROR")
        }
    }
}

