package com.example.classkotlin_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        orderButton.setOnClickListener(this)
        submitButton.setOnClickListener(this)
        toast.setOnClickListener(this)

    }

    override fun onClick(view: View?) {

        when(view?.id){   // it work like switch statement in java....

            R.id.plusButton ->{
                var value= countText.text.toString()
                var number:Int = value.toInt()+1
                countText.text= number.toString()

            }
            R.id.minusButton ->{

                var value= countText.text.toString()
                var number:Int = value.toInt()-1
                countText.text= number.toString()

            }
            R.id.orderButton ->{

                var value= ""
                if(burger.isChecked){
                    value+="Burger "
                }
                if(pizza.isChecked){
                    value+="Pizza "
                }
                if(friedRice.isChecked){
                    value+="Fried Rice "
                }

                if(value ==""){
                    Toast.makeText(this,"No Order",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,value+"is Order",Toast.LENGTH_SHORT).show()
                }
            }

            R.id.submitButton ->{

                when(radioGroup.checkedRadioButtonId){

                    R.id.male ->{
                        Toast.makeText(this,male.text.toString(),Toast.LENGTH_SHORT).show()
                    }
                    R.id.female ->{

                        Toast.makeText(this,female.text.toString(),Toast.LENGTH_SHORT).show()
                    }
                    R.id.other ->{

                        Toast.makeText(this,other.text.toString(),Toast.LENGTH_SHORT).show()
                    }
                    else ->{
                        Toast.makeText(this,"No item Select",Toast.LENGTH_SHORT).show()
                    }
                }

            }
            R.id.toast ->{
                val  intent= Intent(this,ToastActivity::class.java)
                startActivity(intent)

            }



        }

    }
}