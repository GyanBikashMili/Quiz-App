package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val  userName  = intent.getStringExtra(SetData.name)
        val score = intent.getStringExtra(SetData.score)
        val totalquestion = intent.getStringExtra("Total Size")

        val congo = findViewById<TextView>(R.id.congo)
        val Score = findViewById<TextView>(R.id.score)
        val button = findViewById<Button>(R.id.button)

        congo.text = "Congratulations ${userName} !!"
        Score.text = "${score}/ ${totalquestion}"
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}