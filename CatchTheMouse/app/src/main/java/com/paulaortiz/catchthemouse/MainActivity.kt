package com.paulaortiz.catchthemouse

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var gameView: GameView
    private lateinit var scoreTextView: TextView
    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameView = findViewById(R.id.gameView)
        scoreTextView = findViewById(R.id.scoreTextView)
        timerTextView = findViewById(R.id.timerTextView)
        startButton = findViewById(R.id.startButton)
        resetButton = findViewById(R.id.resetButton)

        // Configurar listeners para actualizar UI
        gameView.setScoreListener { score ->
            scoreTextView.text = "Puntuación: $score"
        }

        gameView.setTimerListener { timeLeft ->
            timerTextView.text = "Tiempo: ${timeLeft}s"
        }

        startButton.setOnClickListener {
            gameView.startGame()
            startButton.isEnabled = false
            resetButton.isEnabled = true
        }

        resetButton.setOnClickListener {
            gameView.resetGame()
            scoreTextView.text = "Puntuación: 0"
            timerTextView.text = "Tiempo: 30s"
            startButton.isEnabled = true
            resetButton.isEnabled = false
        }

        // Inicializar valores
        scoreTextView.text = "Puntuación: 0"
        timerTextView.text = "Tiempo: 30s"
        resetButton.isEnabled = false
    }
}