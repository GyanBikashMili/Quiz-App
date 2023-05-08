package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val button = findViewById<Button>(R.id.button)
        val input= findViewById<TextView>(R.id.input)

        button.setOnClickListener {
            if(input.text.toString().isEmpty())
            {
                Toast.makeText(this, "Enter your name",Toast.LENGTH_SHORT).show()
            }
            else {
                var intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("${SetData.name}", input.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}