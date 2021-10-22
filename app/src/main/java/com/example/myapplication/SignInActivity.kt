package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var getResultTextView: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pressLogInBtnEvent()
        pressSignUpBtnEvent()
    }

    //로그인 버튼 눌렀을 때 이벤트
    fun pressLogInBtnEvent() {
        val intentHome = Intent(this, HomeActivity::class.java)
        binding.apply {
            btnLogin.setOnClickListener {
                val userId = etId.text.toString()
                val userPw = etPassword.text.toString()

                if (userId.isNotEmpty() && userPw.isNotEmpty()) {
                    startActivity(intentHome)
                    Toast.makeText(this@SignInActivity, "$userId 님 환영합니다", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    //회원가입 버튼 눌렀을 때 이벤트
    fun pressSignUpBtnEvent() {
        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult -> }
        binding.btnSignup.setOnClickListener {
            startForResult.launch(Intent(this, SignUpActivity::class.java))
        }

        //id, pw 값 가지고 있을 경우 각 editText에 setText
        if (intent.hasExtra("id") && intent.hasExtra("pw")) {
            val id = intent.getStringExtra("id")
            val pw = intent.getStringExtra("pw")

            binding.etId.setText(id)
            binding.etPassword.setText(pw)
        }
    }
}