# Flashcard Quiz App

The Flashcard Quiz App is a mobile Android application created using Kotlin and Android Studio. This educational app helps students revise historical facts through a simple, fun, and interactive quiz format. It’s designed to make learning easy and enjoyable, especially for high school and college students who want to improve their memory and understanding of key historical events and figures.

## Purpose of the App

The goal of this app is to make studying history more interactive and effective. Instead of passively reading textbooks, students can test their knowledge using true or false flashcards. The app helps users practice active recall, which is a powerful technique that improves memory by asking them to retrieve information. Every time a student answers a question, the app gives immediate feedback, helping them learn from their mistakes and remember the correct answers better.

## Personal Design Choices

While designing the app, I put a lot of thought into how it would look and feel. I used darker, bold shades of blue for the primary colour (`#3E4A89`) to give the app a serious, traditional, and academic look, similar to old history books and scholarly material. For the accent colour, I chose a rich red-orange (`#F76C5E`) to create contrast and draw attention to buttons like "Start" and "Next." These colours work together to create a balance between formality and engagement. The fonts are clear and readable, and spacing is generous to give users a sense of calm and clarity while they work through the quiz. Overall, I wanted the app to feel like a digital version of an elegant flashcard set used in a history classroom.

---

## Screens & Features

### 1. Welcome Screen (MainActivity)
- Shows a greeting message and short description.
- Features a Start button that begins the quiz.
- Designed with clean text, central alignment, and strong colour contrast to welcome users.![image](https://github.com/user-attachments/assets/610d1889-615c-4c6c-9933-40954356625c)


### 2. Question Screen (QuestionScreen)
- Displays one history question at a time in a flashcard format.
- Users choose between True and False.
- After selecting, a short message appears: "Correct!" or "Incorrect!"
- A Next button moves to the next question.
- Prevents multiple answers for the same question.![image](https://github.com/user-attachments/assets/ceb40cbe-192b-4a36-a5b3-ef80bc15b7c7)


### 3. Score Screen (ScoreScreen)
- At the end of the quiz, users see their final score out of 5.
- Shows personalized feedback based on performance.
- Offers three options:
  - Review all questions with correct answers.
  - Exit the app.
- Score is capped to prevent it from exceeding 5, even with bugs. ![image](https://github.com/user-attachments/assets/8206f42a-4841-475d-aad9-47591bb5810f)


---

## How the App Works (Logic)

The app uses two arrays in Kotlin:
- One stores the questions (strings)
- The other stores the correct answers (true or false)

  ![image](https://github.com/user-attachments/assets/dfc0452e-5717-42d9-89c0-932b9f0b9330)


When a user taps a button, the app checks their answer against the correct one. If they answer correctly on their first try, their score increases by 1. The score is saved and shown at the end. The user can’t press True or False more than once for each question, so the score remains accurate.

To prevent crashes and bugs:
- Score never goes over the number of questions.
- The app checks for index errors and user errors like double-taps.

---

## Technologies Used

- Kotlin – modern programming language for Android apps.
- Android Studio – main development environment.
- ConstraintLayout – for flexible, responsive UI layouts.
- GitHub – version control and source code management.
- GitHub Actions – automation for building and testing the app.
![image](https://github.com/user-attachments/assets/638a13ec-f6f9-41a1-9b42-b7a1eee8b278) ![image](https://github.com/user-attachments/assets/2bf7b5be-f392-49fd-9301-82bba60face9)


---

## GitHub Integration and GitHub Actions

All development was tracked using GitHub, which allowed for easy backups and version history. GitHub Actions were used to automatically build and test the app every time code was pushed. This means that:
- Every change is checked to make sure it doesn’t break the app.
- The app can be tested on different devices and screen sizes.
- Builds are reproducible, so the app is stable and reliable.

---

## Testing & Reliability

### Manual Testing:
- Each screen was tested for layout and functionality.
- Correct and incorrect answers were tested.
- Users could navigate correctly from start to finish.
- The review and exit buttons worked on every device.

### Automated Testing:
- GitHub Actions tested the app on a virtual Android emulator.
- Made sure the app could build on all environments.

---

## How to Run the App

1. Clone the repository from GitHub.
2. Open the project in Android Studio.
3. Wait for Gradle to sync.
4. Connect your Android phone or use an emulator.
5. Press Run to launch the app.
6. Click Start to begin the quiz.

You will be guided through 5 flashcard questions. When done, you'll get your score and see how you performed.

---

## Code Quality and Documentation

The code is:
- Cleanly written with helpful comments.
- Split into clear Kotlin files for each screen.
- Uses `Log.d` statements to track user activity.
- Prevents bugs like tapping True/False twice or scoring more than possible.

Each file includes attribution and headers so others can understand and reuse the code ethically.

---

## Links

- **GitHub Link**: [https://github.com/Asimit148/ST10471627-Asimit-Shrivastava---IMAD5112-Assignment-2](https://github.com/Asimit148/ST10471627-Asimit-Shrivastava---IMAD5112-Assignment-2)  
- **Canva Video Link**: [https://www.canva.com/design/DAGn6DskWjQ/ARA12MWO7HeZN8pJgG1PLg/edit?utm_content=DAGn6DskWjQ&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton](https://www.canva.com/design/DAGn6DskWjQ/ARA12MWO7HeZN8pJgG1PLg/edit?utm_content=DAGn6DskWjQ&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)  
- **YouTube Video Link**: *(Add your YouTube link here)*

