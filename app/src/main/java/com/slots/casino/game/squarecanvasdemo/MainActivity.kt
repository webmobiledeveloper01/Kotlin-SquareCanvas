@file:OptIn(ExperimentalMaterial3Api::class)

package com.slots.casino.game.squarecanvasdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChipDefaults.shape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slots.casino.game.squarecanvasdemo.ui.theme.SquareCanvasDemoTheme
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SquareCanvasDemoTheme {
                val viewModal: MyViewModel = viewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .onSizeChanged {
                            Log.d(
                                "MainActivity",
                                "onSizeChanged $it ${listbait.floorImage.width} ${listbait.floorImage.height}"
                            )
                            val scaledWidth = if (it.width > it.height) {
                                listbait.floorImage.width.toFloat() * (it.height.toFloat() /
                                        if (listbait.floorImage.height.toFloat() == 0f) {
                                            1f
                                        } else {
                                            listbait.floorImage.height.toFloat()
                                        }
                                        )
                            } else {
                                it.width.toFloat()
                            }
                            val scaledHeight =
                                listbait.floorImage.height.toFloat() * (it.width.toFloat() /
                                        if (listbait.floorImage.width.toFloat() == 0f) {
                                            1f
                                        } else {
                                            listbait.floorImage.width.toFloat()
                                        }
                                        )
                            viewModal.initAndUpdateScaledSize(
                                listbait.floorImage.width.toFloat(),
                                listbait.floorImage.height.toFloat(),
                                scaledWidth,
                                scaledHeight,
                                if (it.width > it.height) (it.width.toFloat() / 2f) - (scaledWidth / 2f) else 0f,
                                it.height.toFloat() / 2f - (scaledHeight / 2f)
                            )
                        },
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main(viewModal: MyViewModel = viewModel()): Unit {

    // This will detect any changes to data and recompose your composable.
    viewModal.onUpdate.value
    val openDialog = remember { mutableStateOf(false) }
    val selectedIndex = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            bitmap = listbait.floorImage.asImageBitmap(),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = {
                        Log.d("MainActivity", "Long press: X: ${it.x} , Y: ${it.y}")
                    })
                }
        )

        viewModal.childTravellersList.forEachIndexed { index, squareInfo ->

            Box(modifier = Modifier
                .offset {
                    IntOffset(
                        squareInfo.posX.roundToInt(),
                        squareInfo.poY.roundToInt()
                    )
                }
                .clickable {
                    Log.d("click", "${index}")
                    selectedIndex.value = index
                    openDialog.value = true
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()

                        viewModal.update(index, dragAmount.x, dragAmount.y)


                    }
                }) {
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(shape)
                        .background(squareInfo.color)
                )
                Text(
                    text = squareInfo.des,
                    Modifier.align(Alignment.Center),
                    color = Color.Black,
                    fontSize = 10.sp
                )
            }

        }

        if (openDialog.value) {

            AlertDialog(
                onDismissRequest = {

                },
                title = {
                    Text(text = "Alert")
                },
                text = {
                    Text(viewModal.childTravellersList[selectedIndex.value].des)
                },
                confirmButton = {
                    Button(

                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("Ok")
                    }
                },
            )

        }

    }

}
