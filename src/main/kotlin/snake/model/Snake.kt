package snake.model

import processing.core.PApplet
import processing.core.PApplet.constrain

data class Snake(
    private val applet: PApplet,
    private val moveSpeed: Float,
    private val bodySize: Float = 20f,
    private val bodyColor: Int = applet.color(255f, 255f, 255f),
    private val headColor: Int = applet.color(0f, 255f, 0f),
    private val body: MutableList<SnakeBody> = mutableListOf(SnakeBody(0f, 0f, bodySize)),
) {

    private var xSpeed = 1f
    private var ySpeed = 0f

    fun show() {
        body.forEachIndexed { index, body ->
            applet.fill(if (index == 0) headColor else bodyColor)
            applet.rect(body.x, body.y, body.bodySize, body.bodySize)
        }
    }

    fun move(xSpeed: Float, ySpeed: Float) {
        this.xSpeed = xSpeed
        this.ySpeed = ySpeed
    }

    fun update() {
        val head = body.first()
        val (constrainedX, constrainedY) = calcNewHeadPos(head)
        val newHead = head.copy(x = constrainedX, y = constrainedY)
        body.add(0, newHead)
        body.removeLast()
    }

    fun checkFoodCollision(snakeFoodRepository: SnakeFoodRepository) {
        val head = body.first()
        val food = snakeFoodRepository.currentFoods.firstOrNull { food ->
            head.x == food.x && head.y == food.y
        }
        food?.let {
            snakeFoodRepository.remove(it)
            body.add(SnakeBody(body.last().x, body.last().y))
        }
    }

    private fun calcNewHeadPos(head: SnakeBody): Pair<Float, Float> {
        val x = head.x + (xSpeed * moveSpeed)
        val y = head.y + (ySpeed * moveSpeed)
        val constrainedX = constrain(x, 0f, applet.width - bodySize)
        val constrainedY = constrain(y, 0f, applet.height - bodySize)
        return Pair(constrainedX, constrainedY)
    }
}

data class SnakeBody(
    val x: Float,
    val y: Float,
    val bodySize: Float = 20f,
)
