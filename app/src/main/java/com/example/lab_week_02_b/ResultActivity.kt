package com.example.lab_week_02_b

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import android.content.Intent
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
        private const val ERROR_KEY = "ERROR_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val backButton = findViewById<Button>(R.id.button)
        backButton.setOnClickListener{
            finish()
        }

        if(intent != null){
            val colorCode = intent.getStringExtra(COLOR_KEY)
            try {
                val backgroundScreen =
                    findViewById<ConstraintLayout>(R.id.background_screen)
                backgroundScreen.setBackgroundColor(Color.parseColor("#$colorCode"))
                val resultMessage =
                    findViewById<TextView>(R.id.color_code_result_message)
                resultMessage.text = getString(R.string.color_code_result_message,
                    colorCode?.uppercase())
            } catch (e: Exception) {
                val resultIntent = Intent()
                resultIntent.putExtra(ERROR_KEY, true)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}