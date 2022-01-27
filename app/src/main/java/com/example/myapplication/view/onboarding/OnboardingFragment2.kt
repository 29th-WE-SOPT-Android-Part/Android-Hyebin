package com.example.myapplication.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOnboarding2Binding

class OnboardingFragment2 : Fragment() {
    private var _binding: FragmentOnboarding2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboarding2Binding.inflate(layoutInflater, container, false)
        initBtnEvent()
        return binding.root
    }

    fun initBtnEvent() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment2_to_onboardingFragment3)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}