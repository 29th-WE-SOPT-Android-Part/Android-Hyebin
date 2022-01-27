package com.example.myapplication.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.adapter.SampleViewPagerAdapter
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.view.camera.CameraFragment
import com.example.myapplication.view.profile.ProfileFragment


class HomeActivity : AppCompatActivity() {
    private lateinit var sampleViewPagerAdapter: SampleViewPagerAdapter
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initAdapter()
        initBottomNavigation()

    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())

        sampleViewPagerAdapter = SampleViewPagerAdapter(this)
        sampleViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpSample.adapter = sampleViewPagerAdapter
    }


    private fun initBottomNavigation() {
        binding.vpSample.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_profile -> {
                    binding.vpSample.currentItem = FIRST_FRAGMENT
                }
                R.id.menu_home -> {
                    binding.vpSample.currentItem = SECOND_FRAGMENT
                }
                else -> {
                    binding.vpSample.currentItem = THIRD_FRAGMENT
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }
}

