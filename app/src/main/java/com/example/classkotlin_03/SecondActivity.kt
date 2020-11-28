package com.example.classkotlin_03

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setTitle("Second Activity")
       val value= intent.getStringExtra("key")
        if (value =="one"){
            text.text="Come from Button One"
        }
        else{
            text.text="Come from Button Two"
        }

        dateButton.setOnClickListener(this)
        timeButton.setOnClickListener(this)

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onClick(view: View?) {

        when(view?.id){

            R.id.dateButton -> {
                val calender = Calendar.getInstance()
                val year = calender.get(Calendar.YEAR)
                val month = calender.get(Calendar.MONTH)
                val day = calender.get(Calendar.DAY_OF_MONTH)
                val datePickerDialog:DatePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->


                    dateText.text= "Date: "+dayOfMonth+"/"+monthOfYear+"/"+year

                }, year, month+1, day)

                datePickerDialog.show()

            }
            R.id.timeButton ->{

                val calender = Calendar.getInstance()
                val hour = calender.get(Calendar.HOUR_OF_DAY)
                val minute = calender.get(Calendar.MINUTE)
                val timePickerDialog:TimePickerDialog=TimePickerDialog(this,
                    TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    timeText.text= "Time: "+hourOfDay +" : "+minute

                },hour,minute,false)
                timePickerDialog.show()



            }
        }


    }
}

