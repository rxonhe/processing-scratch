package snake.repository

import processing.core.PApplet
import snake.model.Grid

data class SnakeFoodRepository(
    val gridReference: Grid,
    val foodSize: Float = 20f,
) {
    val currentFoods = mutableListOf<SnakeFood>()

    fun addRandomFood() {
        val x = (1..gridReference.numCols).random() * foodSize
        val y = (1..gridReference.numRows).random() * foodSize
        currentFoods.add(SnakeFood(x, y, foodSize))
    }

    fun drawFoods(applet: PApplet) {
        currentFoods.forEach { food ->
            applet.fill(255f, 0f, 0f)
            applet.rect(food.x, food.y, food.foodSize, food.foodSize)
        }
    }

    fun remove(food: SnakeFood) {
        currentFoods.remove(food)
        addRandomFood()
    }
}

data class SnakeFood(
    val x: Float,
    val y: Float,
    val foodSize: Float = 20f,
)
