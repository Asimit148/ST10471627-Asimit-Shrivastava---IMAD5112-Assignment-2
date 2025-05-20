package com.example.flashcardapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class ScoreScreen : AppCompatActivity() {
    // Re-declaring the same Questions used in the quiz to show correct answers during review
    private val question = arrayOf(
        "Vladmir Lenin was the founder of the Soviet Union.",
        "President Roosevelt first term began in 1933",
        "King Shaka was the ruler of the zulu kingdom",
        "World war 1 started when Archduke Franz Ferdinand was assassinated",
        "George Washington was the first president of America",
    )
    // Corresponding correct answers for the questions
    private val answers = booleanArrayOf(false, false, true, true, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        // Get the score that was passed from the previous activity using an Intent.
        val score = intent.getIntExtra("ScoreScreen", 0)

        // Finding and linking UI component from the layout.
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView) // Displays the score.
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView) // Displays a custom message based on performance
        val reviewButton = findViewById<Button>(R.id.reviewButton) // Displays all questions and answers when reviewing.
        val exitButton = findViewById<Button>(R.id.exitButton) // Button to exit/close the app.
        val reviewTextView = findViewById<TextView>(R.id.ReviewTextView) // TextView to show reviewed questions and answers.

        try {
            // Set the score display to show how many correct answers the user got.
            scoreTextView.text = "Your score is $score/5"

            // Display personalized feedback based on the user's performance
            feedbackTextView.text = when (score) {
                5 -> "Perfect score! You're a history master! 🎉"
                4 -> "Awesome! Just one away from perfect. 🏆"
                3 -> "Good job! You know your history pretty well. 👍"
                2 -> "Not bad! Keep reviewing and you'll get there. 👀"
                1 -> "A bit of a rough round, but don't give up! 📘"
                else -> "Looks like you’re just getting started. Try again!"
            }

        } catch (e: Exception) {
            Log.e("ScoreScreen", "Error displaying score/feedback: ${e.message}", e)
            scoreTextView.text = "Error displaying score"
            feedbackTextView.text = "Something went wrong."
        }

        // Review button when clicked shows all the questions with the correct answers.
        reviewButton.setOnClickListener {
            try {
                val reviewText = StringBuilder()

                if (question.size != answers.size) {
                    Log.e("ScoreScreen", "Mismatch: ${question.size} questions vs ${answers.size} answers")
                    reviewTextView.text = "Error: Question and answer count mismatch."
                    return@setOnClickListener
                }

                for (i in question.indices) {
                    val q = question.getOrNull(i) ?: "Question not found"
                    val a = if (i in answers.indices) answers[i] else false
                    reviewText.append("Q: $q\n")
                    reviewText.append("A: ${if (a) "True" else "False"}\n\n")
                }

                reviewTextView.text = reviewText.toString()
                reviewTextView.visibility = TextView.VISIBLE
            } catch (e: Exception) {
                Log.e("ScoreScreen", "Error during review: ${e.message}", e)
                reviewTextView.text = "Something went wrong while reviewing."
            }
        }

        // Exit button when clicked closes the app.
        exitButton.setOnClickListener {
            try {
                Log.d("ScoreScreen", "Exiting the app")
                finishAffinity()
            } catch (e: Exception) {
                Log.e("ScoreScreen", "Exit failed: ${e.message}", e)
                finish()
            }
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
