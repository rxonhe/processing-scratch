package common

import common.flexbox.properties.Relative
import processing.core.PApplet

abstract class Component {

    open var relativeWidth: Relative = Relative.UNSET
    open var relativeHeight: Relative = Relative.UNSET

    open var width: Float = 0F
    open var height: Float = 0F

    abstract fun show(applet: PApplet)
}