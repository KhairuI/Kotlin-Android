package com.example.classkotlin_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // no need to find view by Id

        textView.text= "Hello Kotlin"

        button.setOnClickListener {
            Toast.makeText(this,"Kotlin",Toast.LENGTH_SHORT).show()
        }

        loginButton.setOnClickListener {
            if(editText.text.isEmpty()){
                Toast.makeText(this,"Enter a Text",Toast.LENGTH_SHORT).show()
            }
            else{
                val  value= editText.text.toString()
                Toast.makeText(this,""+value,Toast.LENGTH_SHORT).show()
                editText.text.clear()
            }
        }

        changeImageButton.setOnClickListener {

            var value= changeImageButton.text.toString()
            if(value == "Google"){
                imageView.setImageResource(R.drawable.sign_icon)
                changeImageButton.text="Profile"
            }
            else{
                imageView.setImageResource(R.drawable.profile)
                changeImageButton.text="Google"
            }


        }




    }
}