package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// Array of flashcard questions
private val question = arrayOf(
    "Joseph Stalin was the founder of the Soviet Union.",
    "President Roosevelt first term began in 1932",
    "King Shaka was the ruler of the zulu kingdom",
    "World war 1 started when Archduke Franz Ferdinand was assassinated",
    "George Washington was the second president of America",
)

// Array of corresponding answers (true or false) in the same order as the questions above.
private val answers = booleanArrayOf(false, false, true, true, false)

private var index = 0 // Tracks which question the user is currently on
private var score = 0 // Tracks how many correct answers the user has given
private var quizFinished = false // Prevents interactions after the quiz ends
private var hasAnswered = false // Tracks if user has selected an answer before pressing Next

class QuestionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        val questionTextView = findViewById<TextView>(R.id.questionTextView) // Displays current question
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView) // Shows feedback text
        val trueButton = findViewById<Button>(R.id.trueButton) // True button
        val falseButton = findViewById<Button>(R.id.falseButton) // False button
        val nextButton = findViewById<Button>(R.id.nextButton) // Next button

        // Disables the true and false buttons
        fun disableAnswerButtons() {
            trueButton.isEnabled = false
            falseButton.isEnabled = false
        }

        // Enables the true and false buttons
        fun enableAnswerButtons() {
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        }

        // Displays the question at the current index
        fun displayQuestion() {
            try {
                if (index < question.size) {
                    questionTextView.text = question.getOrNull(index) ?: "Question not found."
                    feedbackTextView.text = ""
                    hasAnswered = false // Reset answer flag
                    enableAnswerButtons()
                }
            } catch (e: Exception) {
                Log.e("QuestionScreen", "Error displaying question: ${e.message}", e)
                questionTextView.text = "Error loading question."
            }
        }

        // Handles the logic to check the answer selected by user
        fun checkAnswer(userAnswer: Boolean) {
            try {
                if (!quizFinished && index in answers.indices) {
                    hasAnswered = true // Mark that the user has answered
                    if (userAnswer == answers[index]) {
                        feedbackTextView.text = "Correct"
                        score++
                    } else {
                        feedbackTextView.text = "Incorrect"
                    }
                    disableAnswerButtons() // Prevent multiple selections
                }
            } catch (e: Exception) {
                Log.e("QuestionScreen", "Error checking answer: ${e.message}", e)
                feedbackTextView.text = "An error occurred."
            }
        }

        // True button logic
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        // False button logic
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        // Next button logic
        nextButton.setOnClickListener {
            if (!hasAnswered) {
                Toast.makeText(this, "Please select an answer before proceeding.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            index++ // Move to next question only after answer selected

            if (index < question.size) {
                displayQuestion()
            } else {
                quizFinished = true
                Log.i("QuestionScreen", "Quiz finished. Final score: $score")
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("ScoreScreen", score)
                startActivity(intent)
                finish()
            }
        }

        // Show the first question on launch
        displayQuestion()
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
