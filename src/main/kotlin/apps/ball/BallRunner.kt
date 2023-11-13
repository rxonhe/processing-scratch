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
            LEFT -> {
                ballRepository.clear()
                ballRepository.createBallAt(
                    x = mouseX.toFloat(),
                    y = mouseY.toFloat(),
                    radius = slider.sliderValue,
                    color = GREEN,
                )
            }

            RIGHT -> ballRepository.removeBallAt(x = mouseX.toFloat(), y = mouseY.toFloat())
            else -> Unit
        }
    }
}
