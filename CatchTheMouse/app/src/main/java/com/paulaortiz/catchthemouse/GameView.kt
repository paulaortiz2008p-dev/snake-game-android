package com.paulaortiz.catchthemouse

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var score = 0
    private var timeLeft = 30
    private var isGameRunning = false
    private val mice = mutableListOf<Mouse>()
    private val paint = Paint().apply {
        isAntiAlias = true
    }
    private var gameTimer: CountDownTimer? = null
    private var scoreListener: ((Int) -> Unit)? = null
    private var timerListener: ((Int) -> Unit)? = null

    init {
        setBackgroundColor(Color.WHITE)
    }

    fun setScoreListener(listener: (Int) -> Unit) {
        scoreListener = listener
    }

    fun setTimerListener(listener: (Int) -> Unit) {
        timerListener = listener
    }

    fun startGame() {
        score = 0
        timeLeft = 30
        isGameRunning = true
        mice.clear()
        spawnMouse()

        gameTimer?.cancel()
        gameTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                timerListener?.invoke(timeLeft)
                
                // Generar ratón cada segundo
                if (Random.nextFloat() > 0.3f) {
                    spawnMouse()
                }
                
                invalidate()
            }

            override fun onFinish() {
                isGameRunning = false
                timeLeft = 0
                timerListener?.invoke(0)
                invalidate()
            }
        }.start()
    }

    fun resetGame() {
        gameTimer?.cancel()
        isGameRunning = false
        score = 0
        timeLeft = 30
        mice.clear()
        scoreListener?.invoke(0)
        invalidate()
    }

    private fun spawnMouse() {
        if (mice.size < 3) { // Máximo 3 ratones en pantalla
            val x = Random.nextFloat() * (width - 100) + 50
            val y = Random.nextFloat() * (height - 200) + 50
            mice.add(Mouse(x, y))
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Dibujar ratones
        for (mouse in mice.toList()) {
            // Cuerpo del ratón (círculo gris)
            paint.color = Color.GRAY
            canvas.drawCircle(mouse.x, mouse.y, 30f, paint)

            // Orejas
            paint.color = Color.DKGRAY
            canvas.drawCircle(mouse.x - 15f, mouse.y - 25f, 12f, paint)
            canvas.drawCircle(mouse.x + 15f, mouse.y - 25f, 12f, paint)

            // Ojos
            paint.color = Color.BLACK
            canvas.drawCircle(mouse.x - 10f, mouse.y - 5f, 4f, paint)
            canvas.drawCircle(mouse.x + 10f, mouse.y - 5f, 4f, paint)

            // Cola
            paint.strokeWidth = 3f
            canvas.drawLine(mouse.x + 25f, mouse.y, mouse.x + 50f, mouse.y + 20f, paint)

            // Tiempo de vida del ratón
            mouse.lifetime--
            if (mouse.lifetime <= 0) {
                mice.remove(mouse)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN && isGameRunning) {
            val touchX = event.x
            val touchY = event.y

            for (mouse in mice.toList()) {
                val distance = Math.sqrt(
                    ((touchX - mouse.x) * (touchX - mouse.x) +
                            (touchY - mouse.y) * (touchY - mouse.y)).toDouble()
                )
                if (distance < 40) {
                    score += 10
                    scoreListener?.invoke(score)
                    mice.remove(mouse)
                    spawnMouse()
                    break
                }
            }
            invalidate()
        }
        return true
    }
}