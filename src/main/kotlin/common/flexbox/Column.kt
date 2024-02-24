package common.flexbox

import common.Component
import common.flexbox.properties.AlignItems
import common.flexbox.properties.FlexDirection
import common.flexbox.properties.JustifyContent
import common.flexbox.properties.Margin
import common.flexbox.properties.Padding

data class Column(
    override var width: Float,
    override var height: Float,
    override var children: Collection<Component> = emptySet(),
    override var padding: Padding = Padding(0F, 0F, 0F, 0F),
    override var margin: Margin = Margin(0F, 0F, 0F, 0F),
    override var backgroundColor: Int = 0,
    override var borderColor: Int = 0,
    override var borderWidth: Float = 0F,
    override var borderRadius: Float = 0F,
    var flex: Float = 1F,
    var justifyContent: JustifyContent = JustifyContent.FLEX_START,
    var alignItems: AlignItems = AlignItems.STRETCH,
    var flexDirection: FlexDirection = FlexDirection.ROW
) : Container()


fun column(block: Column.() -> Unit): Column = Column(0F, 0F).apply(block)