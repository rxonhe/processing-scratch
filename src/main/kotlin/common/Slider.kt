package common

import processing.core.PApplet

class Slider(
    private val centerX: Float,
    private val centerY: Float,
    private val width: Float,
) {
    private var position: Float = centerX - width / 2
    private val height: Float = 20f
    private var dragging: Boolean = false
    private val sliderWidth: Float = 10f
    private val sliderHeight: Float = 20f
    private var sliderValue: Float = 50f

    fun show(p: PApplet) {
        p.stroke(0)
        p.fill(150)
        p.rectMode(PApplet.CENTER)
        p.rect(centerX, centerY, width, height)

        p.fill(if (dragging) 100 else 200)
        p.ellipse(position, centerY, sliderWidth, sliderHeight)

        p.fill(0)
        p.textAlign(PApplet.CENTER, PApplet.CENTER)
        sliderValue = getValue() * 100
        p.text(sliderValue.toInt().toString(), centerX, centerY - height)
    }

    fun update(mouseX: Float, mousePressed: Boolean) {
        if (mousePressed && PApplet.abs(mouseX - position) < width / 2 + sliderWidth) {
            dragging = true
        }

        if (!mousePressed) {
            dragging = false
        }

        if (dragging) {
            position = mouseX.coerceIn(centerX - width / 2, centerX + width / 2)
        }
    }

    fun getValue(): Float {
        return PApplet.map(position, centerX - width / 2, centerX + width / 2, 0f, 1f)
    }
}
