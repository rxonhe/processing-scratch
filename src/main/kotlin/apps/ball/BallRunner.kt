package apps.ball

import apps.ball.repository.BallRepository
import apps.ball.resources.GREEN
import apps.ball.resources.HEIGHT
import apps.ball.resources.WIDTH
import common.Slider
import processing.core.PApplet
import java.awt.event.KeyEvent

class BallRunner : PApplet() {
    private val ballRepository = BallRepository()
    private val slider = Slider(100f, 100f, 100f)

    override fun settings() {
        size(WIDTH.toInt(), HEIGHT.toInt())
    }

    override fun setup() {
        ballRepository.createRandomBall()
    }

    override fun draw() {
        // Events

        // Updates
        background(51)
        line(0f, 200f, WIDTH, 200f)
        slider.update(mouseX.toFloat(), mousePressed)

        // Draw
        ballRepository.balls.forEach { ball ->
            ball.show(this)
        }
        slider.show(this)
    }

    override fun keyPressed() = when (keyCode) {
        KeyEvent.VK_ENTER -> ballRepository.createRandomBall()
        else -> Unit
    }

    override fun mousePressed() {
        when (mouseButton) {
            LEFT -> ballRepository.createBallAt(mouseX.toFloat(), mouseY.toFloat(), GREEN)
            RIGHT -> ballRepository.removeBallAt(mouseX.toFloat(), mouseY.toFloat())
            else -> Unit
        }
    }
}
