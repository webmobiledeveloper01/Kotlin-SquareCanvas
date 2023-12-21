package com.slots.casino.game.squarecanvasdemo

import adapter.ItemPlantaAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.text.DecimalFormat
import java.util.Calendar
import android.widget.ImageView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import data.FloorBait
import data.ItemPlanta
import data.SquareInfo
//Global
lateinit var listbait: FloorBait

class MainInspection : ComponentActivity() {
    lateinit var tvInspeccioEstat: TextView
    lateinit var tvInspeccioEmpleat: TextView
    lateinit var tvInspeccioEstabliment: TextView
    lateinit var btDataInici: Button
    lateinit var btFiVisita: Button
    lateinit var btHoraInici: Button
    lateinit var btHoraFi: Button
    lateinit var btStartVisita: Button
    lateinit var rvPlantes: RecyclerView
    lateinit var ivFloor: ImageView
    lateinit var baitList: ArrayList<SquareInfo>
    lateinit var selectFloorItem: ItemPlanta


    val formatInt = DecimalFormat("00")

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0
    var segonde = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_inspection)
        tvInspeccioEstat = findViewById(R.id.tvInspeccioEstat)
        tvInspeccioEmpleat = findViewById(R.id.tvInspeccioEmpleat)
        tvInspeccioEstabliment = findViewById(R.id.tvInspeccioEstabliment)
        btDataInici = findViewById(R.id.btDataInici)
        btFiVisita = findViewById(R.id.btFiVisita)
        btHoraInici = findViewById(R.id.btHoraInici)
        btHoraFi = findViewById(R.id.btHoraFi)
        btStartVisita = findViewById(R.id.btStartVisita)
        rvPlantes = findViewById(R.id.rvPlantes)
        ivFloor = findViewById(R.id.ivFloor)


        initFunctions()
        doInitInformation()
        setContactInfo()

    }

    private fun doInitInformation() {
        tvInspeccioEstat.text = "To be done"
        tvInspeccioEstabliment.text = "Marriott Hotel"
        tvInspeccioEmpleat.text = "Sr Hugo Perez"
        selectFloorItem = ItemPlanta("", "", "")

    }

    private fun getDateTimeCalendar() {
        val cal: Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR_OF_DAY)
        minute = cal.get(Calendar.MINUTE)
        segonde = cal.get(Calendar.SECOND)
    }

    private fun initFunctions() {

        btStartVisita.setOnClickListener {
            setFloorBait()
            Intent(it.context, MainActivity::class.java).also {
                startActivity(it)
            }
        }
        btFiVisita.setOnClickListener {
        }
    }

    public fun setImage(fileName: String) {

    }

    fun setFloorBait() {
        // ArrayList of class ItemsViewModel
        var floorCode = selectFloorItem.codiPlanta
        baitList = ArrayList<SquareInfo>()

        when (floorCode) {
            "P-1" -> {
                baitList.add(SquareInfo(129.0,76.0,Color(0xFFF0A262),"E08"))
                baitList.add(SquareInfo(42.0,162.0,Color(0xFFF0A262),"E09"))
                baitList.add(SquareInfo(461.0,191.0,Color(0xFFF0A262),"E12"))
                baitList.add(SquareInfo(322.0,272.0,Color(0xFFF0A262),"E13"))
                baitList.add(SquareInfo(503.0,29.0,Color(0xFFF06292),"M05"))
                baitList.add(SquareInfo(42.0,182.0,Color(0xFFFFF176),"R02"))
                baitList.add(SquareInfo(326.0,195.0,Color(0xFFFFF176),"R04"))
                baitList.add(SquareInfo(552.0,375.0,Color(0xFFFFF176),"R07"))
                baitList.add(SquareInfo(201.0,76.0,Color(0xFFFFF176),"R08"))
                baitList.add(SquareInfo(626.0,379.0,Color(0xFFFFF176),"R09"))
                baitList.add(SquareInfo(503.0,51.0,Color(0xFFFFF176),"R11"))
                baitList.add(SquareInfo(150.0,133.0,Color(0xFFFFF176),"R12"))
                baitList.add(SquareInfo(422.0,306.0,Color(0xFFFFF176),"R14"))
            }

            "PB" -> {
                baitList.add(SquareInfo(317.0,168.0,Color(0xFFF0A262),"E01"))
                baitList.add(SquareInfo(330.0,32.0,Color(0xFFF0A262),"E02"))
                baitList.add(SquareInfo(162.0,195.0,Color(0xFFF0A262),"E03"))
                baitList.add(SquareInfo(126.0,273.0,Color(0xFFF0A262),"E04"))
                baitList.add(SquareInfo(107.0,37.0,Color(0xFFF0A262),"E05"))
                baitList.add(SquareInfo(186.0,32.0,Color(0xFFF0A262),"E06"))
                baitList.add(SquareInfo(63.0,68.0,Color(0xFFF0A262),"E07"))
                baitList.add(SquareInfo(346.0,381.0,Color(0xFFF0A262),"E11"))
                baitList.add(SquareInfo(3.0,201.0,Color(0xFFF0A262),"E14"))
                baitList.add(SquareInfo(307.0,417.0,Color(0xFFF0A262),"E15"))
                baitList.add(SquareInfo(114.0,293.0,Color(0xFFF06292),"M02"))
                baitList.add(SquareInfo(5.0,223.0,Color(0xFFF06292),"M04"))
            }

            "-1" -> {
                baitList.add(SquareInfo(702.0,418.0,Color(0xFFFFF176),"R04"))
                baitList.add(SquareInfo(190.0,323.0,Color(0xFFFFF176),"R05"))
                baitList.add(SquareInfo(13.0,376.0,Color(0xFFFFF176),"R06"))
            }

            "0" -> {
                baitList.add(SquareInfo(495.0,332.0,Color(0xFFE57373),"BLOCS"))
                baitList.add(SquareInfo(836.0,242.0,Color(0xFFF06292),"M01"))
                baitList.add(SquareInfo(117.0,392.0,Color(0xFFFFF176),"R01"))
                baitList.add(SquareInfo(827.0,80.0,Color(0xFFFFF176),"R02"))
            }

            "1" -> {
                baitList.add(SquareInfo(610.0,270.0,Color(0xFFFFF176),"R03"))
            }
        }

        listbait = FloorBait(
            ivFloor.drawable.toBitmap(),
            baitList
        )
    }

    fun setContactInfo() {
        // getting the recyclerview by its id

        val recyclerview = findViewById<RecyclerView>(R.id.rvPlantes)
        recyclerview.layoutManager = LinearLayoutManager(this)


        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemPlanta>()

        data.add(ItemPlanta("P-1", "Floor -1 external building A", "06046_P-1.jpg"))
        data.add(ItemPlanta("PB", "Floor PB", "06046_PB.jpg"))
        data.add(ItemPlanta("0", "Floor 0", "07014_0.jpg"))
        data.add(ItemPlanta("1", "Floor 1", "07014_1.jpg"))
        data.add(ItemPlanta("-1", "Floor -1", "07014_-1.jpg"))


        // This will pass the ArrayList to our Adapter
        val adapter = ItemPlantaAdapter(data, ivFloor, selectFloorItem)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }


}