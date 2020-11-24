package com.example.classkotlin_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_toast.*
import kotlinx.android.synthetic.main.custom_view.*
import kotlinx.android.synthetic.main.custom_view.view.*

class ToastActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        sampleToast.setOnClickListener(this)
        customToast.setOnClickListener(this)
        errorToast.setOnClickListener(this)
        successToast.setOnClickListener(this)
        infoToast.setOnClickListener(this)
        snackBar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){

            R.id.sampleToast ->{
                Toast.makeText(this,"Simple Toast", Toast.LENGTH_SHORT).show()
            }
            R.id.customToast ->{

                CustomToast()
            }
            R.id.errorToast ->{
                Toasty.error(this,"This is error",Toast.LENGTH_SHORT).show();

            }
            R.id.successToast ->{

                Toasty.success(this,"This is Success",Toast.LENGTH_SHORT).show();
            }
            R.id.infoToast ->{
                Toasty.info(this,"This is info",Toast.LENGTH_SHORT).show();

            }
            R.id.snackBar ->{
                Snackbar.make(linearLayout,"Snack Bar",Snackbar.LENGTH_SHORT).show()

            }


        }

    }

    private fun CustomToast() {
        val view= layoutInflater.inflate(R.layout.custom_view,customViewId)
        view.customTextId.text= "My Toast"
        val  toast= Toast(this)
        toast.duration= Toast.LENGTH_SHORT
        toast.view= view
        toast.show()
    }
}