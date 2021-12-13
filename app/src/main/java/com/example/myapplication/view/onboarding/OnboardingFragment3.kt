package com.example.myapplication.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOnboarding3Binding

class OnboardingFragment3 : Fragment() {
    private lateinit var OnboardingFragment3: FragmentOnboarding3Binding
    private var _binding: FragmentOnboarding3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding3Binding.inflate(layoutInflater, container, false)
        initBtnEvent()

        Glide.with(this)
            .load("https://mblogthumb-phinf.pstatic.net/MjAxOTA0MjNfMjcy/MDAxNTU2MDIwNjg0ODMw.KwUiIDMhdpKzsuNX83GpdFljS1HjgNhCBNcXv2QXfxkg.ksHQVjDUTn8AMV4XVSfETLX-tZ1LTz9-bOmO0o7AtI8g.JPEG.ndh7782/%EC%B9%98%EC%A6%8801.JPG?type=w800")
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivGit)

        return binding.root
    }

    private fun initBtnEvent() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment3_to_signInActivity)

            (activity as OnBoardingActivity).finish()
        }
    }
}