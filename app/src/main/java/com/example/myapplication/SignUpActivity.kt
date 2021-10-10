package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, SignInActivity::class.java)

        //회원가입 완료 버튼 눌렀을 때
        binding.apply {
            btnSingup.setOnClickListener {
                val userName : String = etName.text.toString()
                val userId : String = etId.text.toString()
                val userPw : String = etPassword.text.toString()

                if (userName.isNotEmpty() && userId.isNotEmpty() && userPw.trim().isNotEmpty()) {
                    intent.putExtra("id", userId)
                    intent.putExtra("pw", userPw)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
