package com.slots.casino.game.squarecanvasdemo

import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import data.SquareInfo

class MyViewModel : ViewModel() {
    var childTravellersList = mutableListOf<SquareInfo>()
    val offsets = List(listbait.bait.count()) { 0.dp to 0.dp }.toMutableStateList()

    init {

        for (bait in listbait.bait) {
            childTravellersList.add(SquareInfo(bait.posX, bait.poY, bait.color, bait.des))
        }
//        childTravellersList.add(SquareInfo(20.0,20.0, Color.Red,"R01"))
//        childTravellersList.add(SquareInfo(200.0,200.0, Color.Blue,"E12"))
//        childTravellersList.add(SquareInfo(300.0,30.0, Color.Gray,"M14"))
    }
}