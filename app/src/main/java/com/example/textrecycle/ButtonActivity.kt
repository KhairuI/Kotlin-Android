package com.example.textrecycle

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.textrecycle.databinding.ActivityButtonBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class ButtonActivity : AppCompatActivity(),MyAdapter.OnCardClickListener {

    private lateinit var binding: ActivityButtonBinding
    private var list= mutableListOf<ModelClass>()
    private lateinit var bsFilter: BottomSheetDialog
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeData()
        initilize()
        setBottomSheet()

      /*  val constrainLayout= binding.btnLayout
        val vto= constrainLayout.viewTreeObserver
        val height= constrainLayout.measuredHeight
        Log.d("xxx", "height: $height")
        vto.addOnGlobalLayoutListener {

        }*/

    }

    private fun initilize() {

    }
    private fun pxToDp(px:Int):Int{
        return ((px/ Resources.getSystem().displayMetrics.density).toInt())
    }


    private fun setBottomSheet() {

        val layout = LayoutInflater.from(this).inflate(R.layout.layout_bottom, null, false)
        val rvFilter = layout.findViewById<RecyclerView>(R.id.rv_bottom)
        val constrainLayout= layout.findViewById<ConstraintLayout>(R.id.layoutPayment)
        val button= layout.findViewById<Button>(R.id.btn_trans)
        button.setOnClickListener {
            Log.d("xxx", "payment height: ${ pxToDp(constrainLayout.height)}")
            Log.d("xxx", "layout height: ${ pxToDp(layout.height)}")
        }


        adapter= MyAdapter(this)
        adapter.addAll(list,true)
        rvFilter.setHasFixedSize(true)
        rvFilter.adapter= adapter
        bsFilter = BottomSheetDialog(this).apply {
            setContentView(layout)
            dismissWithAnimation = true
            window?.attributes?.dimAmount = 0f
            setCancelable(false)
            //behavior.peekHeight=50
            behavior.addBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when(newState){
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            Log.d("xxx", "STATE_COLLAPSED")
                            //constrainLayout.translationY= 1f
                            Log.d("xxx", "STATE_COLLAPSED: ${bottomSheet.width}")
                            Log.d("xxx", "STATE_COLLAPSED: ${behavior.maxHeight}")
                        }
                        BottomSheetBehavior.STATE_EXPANDED ->
                        {
                           // constrainLayout.translationY= 50f
                            Log.d("xxx", "STATE_EXPANDED")
                            Log.d("xxx", "STATE_EXPANDED: ${bottomSheet.width}")
                        }
                        BottomSheetBehavior.STATE_DRAGGING -> {
                            Log.d("xxx", "STATE_DRAGGING ")
                        }
//                        BottomSheetBehavior.STATE_SETTLING -> binding.bottomSheet.demoTitle.text="SETTLING"
//                        BottomSheetBehavior.STATE_HIDDEN -> binding.bottomSheet.demoTitle.text="HIDDEN"
//                        BottomSheetBehavior.STATE_HALF_EXPANDED -> binding.bottomSheet.demoTitle.text="HALF_EXPANDED"

                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }

            })
        }

        bsFilter.show()



    }

    private fun makeData() {
        list.add(ModelClass("Burger0","120",true))
        list.add(ModelClass("Burger1","120",false))
        list.add(ModelClass("Burger2","120",false))
        list.add(ModelClass("Burger3","120",false))
        list.add(ModelClass("Burger4","120",false))
        list.add(ModelClass("Burger5","120",false))
        list.add(ModelClass("Burger6","120",false))
        list.add(ModelClass("Burger7","120",false))
        list.add(ModelClass("Burger8","120",false))
        list.add(ModelClass("Burger9","120",false))
        list.add(ModelClass("Burger10","120",false))
        list.add(ModelClass("Burger11","120",false))
        list.add(ModelClass("Burger12","120",false))
        list.add(ModelClass("Burger13","120",false))
        list.add(ModelClass("Burger14","120",false))
        list.add(ModelClass("Burger15","120",false))
        list.add(ModelClass("Burger16","120",false))
        list.add(ModelClass("Burger17","120",false))
        list.add(ModelClass("Burger18","120",false))
        list.add(ModelClass("Burger19","120",false))
        list.add(ModelClass("Burger20","120",false))
        list.add(ModelClass("Burger21","120",false))
        list.add(ModelClass("Burger22","120",false))
        list.add(ModelClass("Burger23","120",false))
        list.add(ModelClass("Burger24","120",false))
        list.add(ModelClass("Burger25","120",false))
        list.add(ModelClass("Burger26","120",false))
        list.add(ModelClass("Burger27","120",false))
        list.add(ModelClass("Burger28","120",false))
        list.add(ModelClass("Burger29","120",false))
        list.add(ModelClass("Burger30","120",false))

    }

    override fun onCardClick(position: Int, name: String) {

    }
}