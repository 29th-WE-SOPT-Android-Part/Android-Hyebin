package com.example.myapplication.view.profile

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityCancelAutoLoginBinding


class CancelAutoLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCancelAutoLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCancelAutoLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initClickEvent()
    }

    private fun initClickEvent() {
        binding.tvOffAutoLogin.setOnClickListener {
            val settings: SharedPreferences = getSharedPreferences("USER_AUTH", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = settings.edit()
            editor.remove("int")
            editor.clear()
            editor.commit()
        }
    }
}