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
    //Corresponding correct answers for the questions
    private val answers = booleanArrayOf(false, false, true, true, false)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

    // Get the score that was passed from the previous activity using an Intent.
    val score = intent.getIntExtra("ScoreScreen", 0)

    // Finding and linking UI component from the layout.
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView) // Displays the score.
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView) // Displays the a custom message based on performance
        val reviewButton = findViewById<Button>(R.id.reviewButton) // Displays all questions and answers when reviewing.
        val exitButton = findViewById<Button>(R.id.exitButton) // Button to trigger review logic
        val reviewTextView = findViewById<TextView>(R.id.ReviewTextView) // Button to exit/close the app.

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

        // Review button when clicked shows all the questions with the correct answers.
        reviewButton.setOnClickListener {
            var reviewText = StringBuilder()

        // Builds the review content line-by-line
            for (i in question.indices) {
                reviewText.append("Q: ${question[i]}/n")
                reviewText.append("A: ${if (answers[i]) "True" else "False"}\n\n")

                // Sets the review text into the review TextView and makes it visible.
                reviewTextView.text = reviewText.toString()
                reviewTextView.visibility = TextView.VISIBLE
            }
            // Exit button when clicked closes the app.
            exitButton.setOnClickListener {
                Log.d("ScoreScreen", "Exiting the app")
                finishAffinity() // Ensures all acitivities are closed - app exits cleanly.

            }

        }
    }
}