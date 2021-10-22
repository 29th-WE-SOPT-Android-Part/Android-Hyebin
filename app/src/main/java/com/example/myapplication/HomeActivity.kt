package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private var postion = FIRST_POSITION
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initTransactionEvent()
    }

    fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositstoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_rv, followerFragment).commit()

        binding.btnFollower.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container_rv, followerFragment) .commit()
        }

        binding.btnRepository.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container_rv, repositstoryFragment) .commit()
        }
    }


    companion object {
        const val FIRST_POSITION = 1
    }

}
