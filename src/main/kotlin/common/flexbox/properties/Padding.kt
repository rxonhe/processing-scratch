package common.flexbox.properties

data class Padding(
    val top: Float,
    val right: Float,
    val bottom: Float,
    val left: Float,
)

fun padding(value: Float) = Padding(value, value, value, value)
fun paddingTop(value: Float) = Padding(value, 0F, 0F, 0F)
fun paddingRight(value: Float) = Padding(0F, value, 0F, 0F)
fun paddingBottom(value: Float) = Padding(0F, 0F, value, 0F)
fun paddingLeft(value: Float) = Padding(0F, 0F, 0F, value)

fun horizontalPadding(value: Float) = Padding(0F, value, 0F, value)
fun verticalPadding(value: Float) = Padding(value, 0F, value, 0F)