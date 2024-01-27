package com.example.arithmeticprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var firstNumEditText: EditText
    private lateinit var secondNumEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumEditText = findViewById(R.id.firstNum)
        secondNumEditText = findViewById(R.id.secondNum)
        //Find all the buttons
        val addButton = findViewById<Button>(R.id.addButton)
        val subButton = findViewById<Button>(R.id.subButton)
        val multButton = findViewById<Button>(R.id.multButton)
        val divButton = findViewById<Button>(R.id.divButton)
        val modButton = findViewById<Button>(R.id.modButton)

        //Set listeners and make them execute the correct functions
        addButton.setOnClickListener{
            executeOperation("+")
        }
        subButton.setOnClickListener{
            executeOperation("-")
        }
        multButton.setOnClickListener {
            executeOperation("*")
        }
        divButton.setOnClickListener {
            executeOperation("/")
        }
        modButton.setOnClickListener {
            executeOperation("%")
        }
    }

    private fun executeOperation(operator: String){
        val firstNumStr = firstNumEditText.text.toString()
        val secondNumStr = secondNumEditText.text.toString()

        if(firstNumStr.isNotEmpty() && secondNumStr.isNotEmpty()){
            val firstNum = firstNumStr.toDouble()
            val secondNum = secondNumStr.toDouble()

            when (operator){
                "+" ->{
                    val result = firstNum + secondNum
                     displayResult(result)
                }
                "-" ->{
                    val result = firstNum - secondNum
                    displayResult(result)
                }
                "*" ->{
                    val result = firstNum * secondNum
                    displayResult(result)
                }
                "/" ->{
                    val result = firstNum / secondNum
                    displayResult(result)
                }
                "%" ->{
                    val result = firstNum % secondNum
                    displayResult(result)
                }
            }
        }
    }

    private fun displayResult(result: Double) {
        val answerTextView: TextView = findViewById(R.id.answer)
        answerTextView.text = "$result"
    }


}