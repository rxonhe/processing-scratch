package snake.core

import processing.core.PApplet
import snake.model.Grid
import snake.model.Snake
import snake.model.SnakeFoodRepository

class SnakeRunner : PApplet() {
    private val grid = Grid(applet = this, height = 600f, width = 600f, cellSize = 20f)
    private val snake = Snake(applet = this, moveSpeed = 20f)
    private val snakeFoodRepository = SnakeFoodRepository(this, gridReference = grid)

    override fun settings() {
        size(grid.width.toInt(), grid.height.toInt())
    }

    override fun setup() {
        frameRate(10f)
        snakeFoodRepository.addRandomFood()
    }

    override fun draw() {
        // Events
        snake.checkFoodCollision(snakeFoodRepository)

        // Updates
        background(51)
        snake.update()

        // Draw
        grid.show()
        snakeFoodRepository.drawFoods()
        snake.show()
    }

    override fun keyPressed() = when (keyCode) {
        LEFT -> snake.move(xSpeed = -1f, ySpeed = 0f)
        RIGHT -> snake.move(xSpeed = 1f, ySpeed = 0f)
        UP -> snake.move(xSpeed = 0f, ySpeed = -1f)
        DOWN -> snake.move(xSpeed = 0f, ySpeed = 1f)
        else -> Unit
    }
}
