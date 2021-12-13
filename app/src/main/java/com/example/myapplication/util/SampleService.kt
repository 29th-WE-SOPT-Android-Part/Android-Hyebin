package com.example.myapplication

import com.example.myapplication.data.RequestLoginData
import com.example.myapplication.data.RequestSignUpData
import com.example.myapplication.data.ResponseLoginData
import com.example.myapplication.data.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postLogin(
        @Body requestLoginData: RequestLoginData
    ) : Call<ResponseLoginData>
}

interface SignUpService {
    @Headers("Content-Type: application/json")
    @POST("user/signup")
    fun postSignUp(
        @Body requestSignUpData: RequestSignUpData
    ) : Call<ResponseSignUpData>
}