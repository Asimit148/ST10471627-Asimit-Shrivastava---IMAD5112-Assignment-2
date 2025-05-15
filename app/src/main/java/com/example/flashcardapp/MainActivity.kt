package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Reference to the "startButton" Button.
        val startButton = findViewById<Button>(R.id.startButton)

        // When the user clicks the "Start" button.
        startButton.setOnClickListener {
            val intent = Intent(this, QuestionScreen::class.java)
                startActivity(intent)
        }
    }
}