package com.example.myapplication.view.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.util.SOPTSharedPreferences
import com.example.myapplication.databinding.ActivitySigninBinding
import com.example.myapplication.shortToast
import com.example.myapplication.view.home.HomeActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    //private lateinit var getResultTextView: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)

        pressLogInBtnEvent()
        pressSignUpBtnEvent()

        initClickEvent()
        isAutoLogin()

        setContentView(binding.root)
    }

    //로그인 버튼 눌렀을 때 이벤트
    private fun pressLogInBtnEvent() {
        val intentHome = Intent(this, HomeActivity::class.java)
        binding.apply {
            btnLogin.setOnClickListener {
                val userId = etId.text.toString()
                val userPw = etPassword.text.toString()

                if (userId.isNotEmpty() && userPw.isNotEmpty()) {
                    startActivity(intentHome)
                    //Toast.makeText(this@SignInActivity, "$userId 님 환영합니다", Toast.LENGTH_SHORT).show()
                    shortToast("$userId 님 환영합니다")
                } else {
                    shortToast("로그인 실패")
                }
            }
        }

    }

    //회원가입 버튼 눌렀을 때 이벤트
    private fun pressSignUpBtnEvent() {
        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult -> }
        binding.tvSignin.setOnClickListener {
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

    private fun initClickEvent() {
        binding.ivAutoLogin.setOnClickListener {
            binding.ivAutoLogin.isSelected = !binding.ivAutoLogin.isSelected

            SOPTSharedPreferences.setAutoLogin(this, binding.ivAutoLogin.isSelected)
        }
    }

    private fun isAutoLogin() {
        if(SOPTSharedPreferences.getAutoLogin(this)) {
            shortToast("자동로그인 완료")
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}