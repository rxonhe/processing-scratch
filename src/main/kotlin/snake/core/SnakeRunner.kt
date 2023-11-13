package snake.core

import processing.core.PApplet
import snake.model.Grid
import snake.model.Snake
import snake.repository.SnakeFoodRepository

class SnakeRunner : PApplet() {
    private val grid = Grid(height = 600f, width = 600f, cellSize = 20f)
    private val snake = Snake(moveSpeed = 20f)
    private val snakeFoodRepository = SnakeFoodRepository(gridReference = grid)

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
        snake.update(this)

        // Draw
        grid.show(this)
        snakeFoodRepository.drawFoods(this)
        snake.show(this)
    }

    override fun keyPressed() = when (keyCode) {
        LEFT -> snake.move(xSpeed = -1f, ySpeed = 0f)
        RIGHT -> snake.move(xSpeed = 1f, ySpeed = 0f)
        UP -> snake.move(xSpeed = 0f, ySpeed = -1f)
        DOWN -> snake.move(xSpeed = 0f, ySpeed = 1f)
        else -> Unit
    }
}
