package com.example.material_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.material_design.adapter.ViewPagerAdapter
import com.example.material_design.databinding.ActivityFourthBinding
import com.example.material_design.fragments.CallFragment
import com.example.material_design.fragments.InsertFragment
import com.example.material_design.fragments.MessageFragment

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    private lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        title="Contact tab"

        binding.tabLayout.setupWithViewPager(binding.viewPager)
        adapter= ViewPagerAdapter(supportFragmentManager,0).apply {
            addFragment(MessageFragment(),"Message")
            addFragment(CallFragment(),"Call")
            addFragment(InsertFragment(),"Insert")
        }
        binding.viewPager.adapter= adapter
        binding.tabLayout.apply {
            getTabAt(0)?.setIcon(R.drawable.ic_message)
            getTabAt(1)?.setIcon(R.drawable.ic_call)
            getTabAt(2)?.setIcon(R.drawable.ic_add)
        }

        // set badge message
        val messageBadge= binding.tabLayout.getTabAt(0)?.orCreateBadge
        messageBadge?.apply {
            isVisible = true
            number= 12
        }
        // set badge call
        val callBadge= binding.tabLayout.getTabAt(1)?.orCreateBadge
        callBadge?.apply {
            isVisible = true
            number= 2
        }




    }
}