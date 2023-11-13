package apps.ball.core

import apps.ball.resources.RED
import processing.core.PApplet

data class Ball(
    val x: Float,
    val y: Float,
    val radius: Float,
    val ballColor: Triple<Float, Float, Float> = RED,
) {
    fun show(applet: PApplet) {
        applet.fill(ballColor.first, ballColor.second, ballColor.third)
        applet.ellipse(x, y, radius, radius)
    }
}
