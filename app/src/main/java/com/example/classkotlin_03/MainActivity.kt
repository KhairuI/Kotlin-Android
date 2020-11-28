package com.example.classkotlin_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // buttons
        buttonOne.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("key","one")
            startActivity(intent)
        }

        buttonTwo.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("key","two")
            startActivity(intent)
        }

        // spinner....
        val countryList = resources.getStringArray(R.array.country)
        spinnerView.adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countryList)

        spinnerView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val value= countryList.get(p2)

                Toast.makeText(this@MainActivity,value,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }


        }



       }
