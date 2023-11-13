package ball.repository

import ball.core.Ball
import ball.resources.HEIGHT
import ball.resources.MAX_RADIUS
import ball.resources.MIN_RADIUS
import ball.resources.RED
import ball.resources.WIDTH
import java.awt.geom.Point2D.distance

data class BallRepository(
    val balls: MutableSet<Ball> = mutableSetOf(),
) {
    fun createRandomBall(color: Triple<Float, Float, Float> = RED) {
        val randomRadius = (MIN_RADIUS.toInt()..MAX_RADIUS.toInt()).random().toFloat()
        val ball = Ball(
            radius = randomRadius,
            x = (0 + randomRadius.toInt()..(WIDTH - randomRadius).toInt()).random().toFloat(),
            y = (0 + randomRadius.toInt()..(HEIGHT - randomRadius).toInt()).random().toFloat(),
            ballColor = color,
        )
        balls.add(ball)
    }

    fun createBallAt(x: Float, y: Float, color: Triple<Float, Float, Float> = RED) {
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
            val distance = distance(x.toDouble(), y.toDouble(), ball.x.toDouble(), ball.y.toDouble()).toFloat()
            distance < ball.radius
        }
    }
}
