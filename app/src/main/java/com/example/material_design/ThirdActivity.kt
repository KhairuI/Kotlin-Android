package com.example.material_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.material_design.databinding.ActivityThirdBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.demoText.text= getString(R.string.dummy_text)
        binding.bottomLayout.titleLayout.setOnClickListener {

            if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED){
                bottomSheetBehavior.state= BottomSheetBehavior.STATE_COLLAPSED
            }
            else{
                bottomSheetBehavior.state= BottomSheetBehavior.STATE_EXPANDED
            }
        }
        bottomSheetBehavior= BottomSheetBehavior.from(binding.bottomLayout.layoutCustomSheet)
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){

            override fun onStateChanged(bottomSheet: View, newState: Int) {
               when(newState){
                   BottomSheetBehavior.STATE_COLLAPSED -> binding.tvStatus.text="COLLAPSED"
                   BottomSheetBehavior.STATE_EXPANDED -> binding.tvStatus.text="EXPANDED"
                   BottomSheetBehavior.STATE_DRAGGING -> binding.tvStatus.text="DRAGGING"
                   BottomSheetBehavior.STATE_SETTLING -> binding.tvStatus.text="SETTLING"
                   BottomSheetBehavior.STATE_HIDDEN -> binding.tvStatus.text="HIDDEN"
                   BottomSheetBehavior.STATE_HALF_EXPANDED ->  binding.tvStatus.text="HALF_EXPANDED"
               }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

                binding.bottomLayout.titleIcon.rotation= slideOffset * 180
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.setting ->{

                val intent= Intent(this,FifthActivity::class.java)
                intent.putExtra("page",1)
                startActivity(intent)
            }
            R.id.logout ->{
               // shawSnackBar("Logout")
                startActivity(Intent(this,SixthActivity::class.java))
            }
            R.id.call ->{
                startActivity(Intent(this,FourthActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun shawSnackBar(message:String){
        Snackbar.make(binding.topLayout,message, Snackbar.LENGTH_SHORT).show()
    }
}