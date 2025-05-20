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


// Title: Flashcard Quiz App – Open-Source Reference
// Author: F-Droid
// Date: 20 May 2025
// Version: 1.0
// Available: https://f-droid.org

// Title: Flashcard Quiz App – Academic Module Reference
// Author: The Independent Institute of Education (IIE)
// Date: 20 May 2025
// Version: 1.0
// Available: IMAD Module Manual (2025), IMAD5112

// Title: Flashcard Quiz App – Spaced Repetition Inspiration
// Author: Mnemosyne Project
// Date: 20 May 2025
// Version: 1.0
// Available: https://mnemosyne-proj.org

// Title: Kotlin Logic – if..else Expression
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/kotlin/kotlin_conditions.php

// Title: Kotlin Programming – Arrays Usage
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/kotlin/kotlin_arrays.php

// Title: Android Development – User Interface Design
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/android/android_ui.asp

// Title: Android Interaction – Button Click Event Handling
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/android/android_event_handling.asp

// Title: Android UI – Layout Management
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/android/android_layout.asp

// Title: DevOps Integration – GitHub Actions for CI/CD
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/devops/devops_ci_cd_github_actions.php

// Title: Kotlin Syntax – Function Usage and Declaration
// Author: W3Schools
// Date: 20 May 2025
// Version: 1.0
// Available: https://www.w3schools.com/kotlin/kotlin_functions.php