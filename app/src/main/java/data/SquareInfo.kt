package data

import androidx.compose.ui.graphics.Color

data class SquareInfo(
    var posX: Double,
    var poY: Double,
    val color: Color,
    val des: String,
    var offsetX:Float =0f,
    var offsetY:Float = 0f
)
