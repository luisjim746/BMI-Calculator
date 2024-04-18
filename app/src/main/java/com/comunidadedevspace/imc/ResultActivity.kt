package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_BMI,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()

        val classification: String
        val textColor: Int

        if (result <= 18.5f) {
            classification ="THINNESS"
            textColor = ContextCompat.getColor(this, R.color.thinness_color)
        } else if (result > 18.5f && result <= 24.9f) {
            classification ="NORMAL"
            textColor = ContextCompat.getColor(this, R.color.normal_color)
        } else if (result > 25f && result <= 29.9f) {
            classification ="OVERWEIGHT"
            textColor = ContextCompat.getColor(this, R.color.overweight_color)
        } else if ( result > 30f && result <= 39.9f) {
            classification ="OBESITY"
            textColor = ContextCompat.getColor(this, R.color.obesity_color)
        } else {
            classification ="SEVERE OBESITY"
            textColor = ContextCompat.getColor(this, R.color.severe_obesity_color)
        }

        tvClassification.text = classification
        tvClassification.setTextColor(textColor)
    }
}