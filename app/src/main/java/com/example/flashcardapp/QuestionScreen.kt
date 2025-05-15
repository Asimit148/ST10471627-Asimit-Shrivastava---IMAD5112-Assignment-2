package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Array of flashcard questions
private val question = arrayOf(
    "Joseph Stalin was the founder of the Soviet Union.",
    "President Roosevelt first term began in 1932",
    "King Shaka was the ruler of the zulu kingdom",
    "World war 1 started when Archduke Franz Ferdinand was assassinated",
    "George Washington was the second president of America",

    )
// Array of corresponding answers (true or false) in the same order as the questions above.
private val answers = booleanArrayOf(false, false, true, true, false) // A parallel Boolean array storing the correct answers for the questions above.
private var index = 0 // 'index' keeps track of which question the user is currently on (starting from 0)
private var score = 0 // 'score' keeps track of how many correct answers the user has given.


class QuestionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        // Finding all view from the layout that we'll be interacting with.
        val questionTextView = findViewById<TextView>(R.id.questionTextView) // Displays the current question.
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView) // Displays the feedback (Correct/incorrect).
        val trueButton = findViewById<Button>(R.id.trueButton) // Button for answering 'True"
        val falseButton = findViewById<Button>(R.id.falseButton) // Button for answering 'False'
        val nextButton= findViewById<Button>(R.id.nextButton) // Button to go to the next question.

        // Function to display a question and reset the feedback label.

        fun displayQuestion() {
            if (index< question.size) {
                // If we haven't reached the end, show the current question.

            questionTextView.text = question[index]
                feedbackTextView.text = ""// Clear any previous feedback.
            } else { // If all questions have been answered then move to the Score screen.
                val intent = Intent(this, ScoreScreen::class.java)

                // Pass the user's score to the Score screen using intent extras.
                intent.putExtra("ScoreScreen", score)

                //Start the Score screen activity.
                startActivity(intent)

                //Close this activity so the user can't come back using the back button.
                finish()
            }
        }

    }
}