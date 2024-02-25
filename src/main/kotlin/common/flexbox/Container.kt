package common.flexbox

import common.Component
import common.flexbox.properties.Margin
import common.flexbox.properties.Padding
import common.flexbox.properties.Relative
import processing.core.PApplet

abstract class Container : Component() {

    abstract var children: MutableCollection<Component>
    abstract var padding: Padding
    abstract var margin: Margin
    abstract var backgroundColor: Int
    abstract var borderColor: Int
    abstract var borderWidth: Float
    abstract var borderRadius: Float


    override fun show(applet: PApplet) {
        applet.pushStyle()
        applet.fill(backgroundColor)
        applet.stroke(borderColor)
        applet.strokeWeight(borderWidth)
        applet.rect(
            margin.left,
            margin.top,
            width - margin.right - margin.left,
            height - margin.bottom - margin.top,
            borderRadius
        )
        applet.popStyle()
        applet.translate(padding.left, padding.top)
        children.forEach {

            if (it.relativeWidth == Relative.PARENT_WIDTH) it.width = width - padding.left - padding.right
            if (it.relativeHeight == Relative.PARENT_HEIGHT) it.height = height - padding.top - padding.bottom

            it.show(applet)
        }
    }

}