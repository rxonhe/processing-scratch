package apps.scratch

import apps.ball.util.HEIGHT
import apps.ball.util.WIDTH
import common.flexbox.column
import processing.core.PApplet
import java.awt.event.KeyEvent

class Scratch : PApplet() {

    override fun setup() {}

    private fun show() {
        column {
            height = 100F
            width = 100F
            backgroundColor = color(255, 0, 0)
        }.show(this)
    }

    private fun updates() {
        background(51)
    }

    private fun events() {}


    override fun keyPressed() = when (keyCode) {
        KeyEvent.VK_ENTER -> Unit
        else -> Unit
    }

    override fun mousePressed() {
        when (mouseButton) {
            LEFT -> Unit
            RIGHT -> Unit
            else -> Unit
        }
    }

    override fun settings() {
        size(WIDTH.toInt(), HEIGHT.toInt())
    }

    override fun draw() {
        events()
        updates()
        show()
    }

}
