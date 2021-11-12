package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    //private var postion = FIRST_POSITION
    private lateinit var SampleViewPagerAdapter: SampleViewPagerAdapter
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        //initTransactionEvent()
        initAdapter()
        initBottomNavigation()

        setContentView(binding.root)

    }

//    fun initTransactionEvent() {
//        val followerFragment = FollowerFragment()
//        val repositstoryFragment = RepositoryFragment()
//
//        supportFragmentManager.beginTransaction().add(R.id.container_rv, followerFragment).commit()
//
//        binding.btnFollower.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.container_rv, followerFragment) .commit()
//        }
//
//        binding.btnRepository.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.container_rv, repositstoryFragment) .commit()
//        }
//    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())

        SampleViewPagerAdapter = SampleViewPagerAdapter(this)
        SampleViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpSample.adapter = SampleViewPagerAdapter
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
                    return@setOnItemSelectedListener true

                }
                R.id.menu_home -> {
                    binding.vpSample.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpSample.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }


}

