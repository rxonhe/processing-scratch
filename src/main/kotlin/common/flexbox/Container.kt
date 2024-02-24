package common.flexbox

import common.Component
import common.flexbox.properties.Margin
import common.flexbox.properties.Padding
import processing.core.PApplet

abstract class Container : Component() {

    abstract var width: Float
    abstract var height: Float
    abstract var children: Collection<Component>
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
        children.forEach { it.show(applet) }
    }

}