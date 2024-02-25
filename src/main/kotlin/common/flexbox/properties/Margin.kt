package common.flexbox.properties

data class Margin(
    val top: Float,
    val right: Float,
    val bottom: Float,
    val left: Float,
)

fun margin(value: Float) = Margin(value, value, value, value)
fun marginTop(value: Float) = Margin(value, 0F, 0F, 0F)
fun marginRight(value: Float) = Margin(0F, value, 0F, 0F)
fun marginBottom(value: Float) = Margin(0F, 0F, value, 0F)
fun marginLeft(value: Float) = Margin(0F, 0F, 0F, value)

fun horizontalMargin(value: Float) = Margin(0F, value, 0F, value)
fun verticalMargin(value: Float) = Margin(value, 0F, value, 0F)
