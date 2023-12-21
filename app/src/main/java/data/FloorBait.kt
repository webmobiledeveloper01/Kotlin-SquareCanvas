package data

import android.graphics.Bitmap
import java.io.Serializable

data class FloorBait (
    var floorImage : Bitmap,
    var bait : ArrayList<SquareInfo>

) : Serializable