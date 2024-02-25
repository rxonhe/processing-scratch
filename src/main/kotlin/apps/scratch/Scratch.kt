package apps.scratch

import apps.ball.util.HEIGHT
import apps.ball.util.WIDTH
import common.flexbox.column
import common.flexbox.properties.Relative
import common.flexbox.properties.padding
import processing.core.PApplet
import java.awt.event.KeyEvent

class Scratch : PApplet() {

    override fun setup() {}

    private fun show() {
        column {
            height = HEIGHT
            width = WIDTH
            backgroundColor = color(255, 0, 0)
            padding = padding(10F)
            children = mutableSetOf(
                column {
                    relativeHeight = Relative.PARENT_HEIGHT
                    relativeWidth = Relative.PARENT_WIDTH
                    backgroundColor = color(0, 255, 0)
                }
            )
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
