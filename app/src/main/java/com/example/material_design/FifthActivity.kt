package com.example.material_design

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.viewpager.widget.ViewPager
import com.example.material_design.R.color
import com.example.material_design.R.color.*
import com.example.material_design.adapter.ViewPagerAdapter
import com.example.material_design.databinding.ActivityFifthBinding
import com.example.material_design.fragments.CallFragment
import com.example.material_design.fragments.InsertFragment
import com.example.material_design.fragments.MessageFragment

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    private lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewPager()
        getPage()

        binding.btnCall.setOnClickListener {
            onCallSelected()
        }
        binding.btnMessage.setOnClickListener {
            onMessageSelected()
        }

    }

    private fun getPage() {
        val page= intent.getIntExtra("page",0)
        if(page==1) onCallSelected()
        else onMessageSelected()
    }

    private fun setViewPager() {
        adapter= ViewPagerAdapter(supportFragmentManager,0).apply {
            addFragment(MessageFragment(),"Message")
            addFragment(CallFragment(),"Call")
        }
        binding.viewPager.adapter= adapter
        binding.viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                if(position==0) onMessageSelected()
                else onCallSelected()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    @SuppressLint("ResourceType")
    private fun onCallSelected() {
        // set self
        binding.btnCall.strokeColor= ContextCompat.getColorStateList(this, select)
        binding.btnCall.setTextColor(ContextCompat.getColorStateList(this, select))

        // set other
        binding.btnMessage.strokeColor= ContextCompat.getColorStateList(this, not_select)
        binding.btnMessage.setTextColor(ContextCompat.getColorStateList(this, not_select))

        binding.viewPager.setCurrentItem(1,true)
    }

    private fun onMessageSelected() {
        // set self
        binding.btnMessage.strokeColor= ContextCompat.getColorStateList(this, select)
        binding.btnMessage.setTextColor(ContextCompat.getColorStateList(this, select))

        // set other
        binding.btnCall.strokeColor= ContextCompat.getColorStateList(this, not_select)
        binding.btnCall.setTextColor(ContextCompat.getColorStateList(this, not_select))

        binding.viewPager.setCurrentItem(0,true)
    }
}