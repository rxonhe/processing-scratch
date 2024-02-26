package apps.ball.repository

import apps.ball.model.Ball
import apps.ball.util.APP_HEIGHT
import apps.ball.util.MAX_RADIUS
import apps.ball.util.MIN_RADIUS
import apps.ball.util.RED
import apps.ball.util.APP_WIDTH
import processing.core.PApplet.constrain
import processing.core.PApplet.dist

data class BallRepository(
    val balls: MutableSet<Ball> = mutableSetOf(),
    val safeAreaSize: Float = 200f,
) {
    private val width = APP_WIDTH
    private val height = APP_HEIGHT
    private val minX: Int = 0
    private val minY: Int = 0 + safeAreaSize.toInt()

    fun createRandomBall(color: Triple<Float, Float, Float> = RED) {
        val randomRadius = (MIN_RADIUS.toInt()..MAX_RADIUS.toInt()).random().toFloat()
        val ball = Ball(
            radius = randomRadius,
            x = (minX + randomRadius.toInt()..(width - randomRadius).toInt()).random().toFloat(),
            y = (minY + randomRadius.toInt()..(height - randomRadius).toInt()).random().toFloat(),
            ballColor = color,
        )
        balls.add(ball)
    }

    fun createBallAt(x: Float, y: Float, radius: Float? = null, color: Triple<Float, Float, Float> = RED) {
        val chosenRadius = (MIN_RADIUS.toInt()..MAX_RADIUS.toInt()).random().toFloat()
        val requestedRadius =
            radius?.let { constrain(it, 0f, 100f) }?.times(MAX_RADIUS - MIN_RADIUS)?.div(100f)?.plus(MIN_RADIUS)
        val effectiveRadius = requestedRadius ?: chosenRadius
        if (y - chosenRadius <= safeAreaSize) return
        val ball = Ball(
            radius = effectiveRadius,
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

    fun clear() {
        balls.clear()
    }
}
