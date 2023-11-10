package snake.model

import processing.core.PApplet

class Grid(
    private val applet: PApplet,
    val height: Float,
    val width: Float,
    private val cellSize: Float,
) {

    val numRows = (height / cellSize).toInt()
    val numCols = (width / cellSize).toInt()

    fun show() {
        applet.stroke(applet.color(75, 75, 75))
        applet.strokeWeight(1f)
        (0..numRows).forEach { row ->
            applet.line(0f, row * cellSize, width, row * cellSize)
        }
        (0..numCols).forEach { col ->
            applet.line(col * cellSize, 0f, col * cellSize, height)
        }
    }
}
