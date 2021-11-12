package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
//        val intentHome = Intent(this, HomeActivity::class.java)
        binding.apply {
            btnLogin.setOnClickListener {
                initNetwork()
//                val userId = etId.text.toString()
//                val userPw = etPassword.text.toString()
//
//                if (userId.isNotEmpty() && userPw.isNotEmpty()) {
//                    startActivity(intentHome)
//                    Toast.makeText(this@SignInActivity, "$userId 님 환영합니다", Toast.LENGTH_SHORT)
//                        .show()
//                } else {
//                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
//                }
            }
        }

    }

    //회원가입 버튼 눌렀을 때 이벤트
    fun pressSignUpBtnEvent() {
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

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            binding.etId.text.toString(),
            binding.etPassword.text.toString()
        )

        val call : Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    Toast.makeText(this@SignInActivity, "${response.body()?.data?.name}님 반갑습니다", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity,HomeActivity::class.java))
                } else {
                    Toast.makeText(this@SignInActivity, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", "error: $t")
            }

        })
    }

    

}