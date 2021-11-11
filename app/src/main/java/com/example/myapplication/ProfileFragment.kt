package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var ProfileFragment: FragmentProfileBinding
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        initTransactionEvent()
        Glide.with(this)
            .load("https://mblogthumb-phinf.pstatic.net/MjAxOTA0MjNfMjcy/MDAxNTU2MDIwNjg0ODMw.KwUiIDMhdpKzsuNX83GpdFljS1HjgNhCBNcXv2QXfxkg.ksHQVjDUTn8AMV4XVSfETLX-tZ1LTz9-bOmO0o7AtI8g.JPEG.ndh7782/%EC%B9%98%EC%A6%8801.JPG?type=w800")
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivProfile)

        binding.btnFollower.isSelected = true;

        return binding.root
    }

    fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositstoryFragment = RepositoryFragment()

        getActivity()?.getSupportFragmentManager()

        getActivity()?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.container_rv, followerFragment)?.commit()

        binding.btnFollower.setOnClickListener {
            getActivity()?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container_rv, followerFragment)?.commit()
            binding.btnFollower.isSelected = true;
            binding.btnRepository.isSelected = false;
        }

        binding.btnRepository.setOnClickListener {
            getActivity()?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container_rv, repositstoryFragment)?.commit()
            binding.btnRepository.isSelected = true;
            binding.btnFollower.isSelected = false;
        }
    }

}