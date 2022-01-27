package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySigninBinding
import com.example.myapplication.view.home.HomeActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentHome = Intent(this, HomeActivity::class.java)
        val intentSingUp = Intent(this, SignUpActivity::class.java)

        binding.apply {
            //로그인 버튼 눌렀을 때
            btnLogin.setOnClickListener {
                val userId : String = etId.text.toString()
                val userPw : String = etPassword.text.toString()

                if (userId.isNotEmpty() && userPw.isNotEmpty()
                ) {
                    startActivity(intentHome)
                    Toast.makeText(this@SignInActivity, "$userId 님 환영합니다", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //회원가입 버튼 눌렀을 때
        binding.tvSignin.setOnClickListener {
            startActivity(intentSingUp)
            finish()
        }


        //id, pw 값 가지고 있을 경우 각 editText에 setText
        binding.apply {
            if (intent.hasExtra("id") && intent.hasExtra("pw")) {
                val id = intent.getStringExtra("id")
                val pw = intent.getStringExtra("pw")

                etId.setText(id)
                etPassword.setText(pw)
            }
        }

    }
}