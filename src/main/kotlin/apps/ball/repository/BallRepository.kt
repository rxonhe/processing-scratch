package apps.ball.repository

import apps.ball.core.Ball
import apps.ball.resources.HEIGHT
import apps.ball.resources.MAX_RADIUS
import apps.ball.resources.MIN_RADIUS
import apps.ball.resources.RED
import apps.ball.resources.WIDTH
import processing.core.PApplet.dist

data class BallRepository(
    val balls: MutableSet<Ball> = mutableSetOf(),
    val safeAreaSize: Float = 200f,
) {
    private val width = WIDTH
    private val height = HEIGHT - safeAreaSize

    fun createRandomBall(color: Triple<Float, Float, Float> = RED) {
        val randomRadius = (MIN_RADIUS.toInt()..MAX_RADIUS.toInt()).random().toFloat()
        val ball = Ball(
            radius = randomRadius,
            x = (0 + randomRadius.toInt()..(width - randomRadius).toInt()).random().toFloat(),
            y = (0 + randomRadius.toInt()..(height - randomRadius).toInt()).random().toFloat(),
            ballColor = color,
        )
        balls.add(ball)
    }

    fun createBallAt(x: Float, y: Float, color: Triple<Float, Float, Float> = RED) {
        if (y <= safeAreaSize) return
        val ball = Ball(
            radius = (MIN_RADIUS.toInt()..MAX_RADIUS.toInt()).random().toFloat(),
            x = x,
            y = y,
            ballColor = color,
        )
        balls.add(ball)
    }

    fun removeBallAt(x: Float, y: Float) {
        balls.removeIf { ball ->
            val distance = dist(x, y, ball.x, ball.y)
            distance < ball.radius
        }
    }
}
