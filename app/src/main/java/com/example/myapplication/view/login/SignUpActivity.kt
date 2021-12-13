package com.example.myapplication.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.RequestSignUpData
import com.example.myapplication.data.ResponseSignUpData
import com.example.myapplication.SignUpCreator
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.example.myapplication.shortToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pressSingUpBtnEvent()
    }

    //회원가입 완료 버튼 눌렀을 때 이벤트
    fun pressSingUpBtnEvent() {
        val intent = Intent(this, SignInActivity::class.java)
        binding.apply {
            btnSingup.setOnClickListener {

                initNetwork()

                val userName = etName.text.toString()
                val userId = etId.text.toString()
                val userPw = etPassword.text.toString()


                if (userName.isNotEmpty() && userId.isNotEmpty() && userPw.trim().isNotEmpty()) {
                    intent
                        .putExtra("id", userId)
                        .putExtra("pw", userPw)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
                    shortToast("입력되지 않은 정보가 있습니다.")
                }
            }
        }
    }

    private fun initNetwork() {
        val requestSignUpData = RequestSignUpData(
            binding.etName.text.toString(),
            binding.etId.text.toString(),
            binding.etPassword.text.toString()
        )

        val call : Call<ResponseSignUpData> = SignUpCreator.signUpService.postSignUp(requestSignUpData)
        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    //Toast.makeText(this@SignUpActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                    response.body()?.message?.let { shortToast(it) }
                } else {
                    Toast.makeText(this@SignUpActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    shortToast("회원가입 실패")

                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.e("NetworkTest", "error: $t")
            }
        })
    }
}

