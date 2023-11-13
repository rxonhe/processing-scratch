package ball

import ball.repository.BallRepository
import ball.resources.GREEN
import ball.resources.HEIGHT
import ball.resources.WIDTH
import processing.core.PApplet
import java.awt.event.KeyEvent

class BallRunner : PApplet() {
    private val ballRepository = BallRepository()

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

        // Draw
        ballRepository.balls.forEach { ball ->
            ball.show(this)
        }
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
