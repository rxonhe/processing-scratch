package ball.core

import processing.core.PApplet

data class Ball(
    val x: Float,
    val y: Float,
    val radius: Float,
    val ballColor: Triple<Float, Float, Float> = Triple(255f, 0f, 0f),
) {
    fun show(applet: PApplet) {
        applet.fill(ballColor.first, ballColor.second, ballColor.third)
        applet.ellipse(x, y, radius, radius)
    }
}
