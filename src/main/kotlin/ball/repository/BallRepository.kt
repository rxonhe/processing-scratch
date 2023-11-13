package ball.repository

import ball.core.Ball
import ball.resources.HEIGHT
import ball.resources.MAX_RADIUS
import ball.resources.WIDTH

data class BallRepository(
    val balls: MutableSet<Ball> = mutableSetOf(),
) {
    fun createRandomBall() {
        val randomRadius = (0..MAX_RADIUS.toInt()).random().toFloat()
        val ball = Ball(
            radius = randomRadius,
            x = (0 + randomRadius.toInt()..(WIDTH - randomRadius).toInt()).random().toFloat(),
            y = (0 + randomRadius.toInt()..(HEIGHT - randomRadius).toInt()).random().toFloat(),
        )
        balls.add(ball)
    }
}
