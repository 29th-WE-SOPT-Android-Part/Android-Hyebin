package com.example.myapplication.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.adapter.FollowerAdapter
import com.example.myapplication.data.FollowerData
import com.example.myapplication.databinding.FollowerFragmentBinding


class FollowerFragment : Fragment() {
    private lateinit var follwerAdapter: FollowerAdapter
    private var _binding: FollowerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FollowerFragmentBinding.inflate(layoutInflater, container,false)


        follwerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = follwerAdapter

        follwerAdapter.userList.addAll(
            listOf(
                FollowerData("스폰지밥", "안녕하세요", "https://ww.namu.la/s/bd52223e4d1f11fcc4c7f6506bf3321b26579bf118db6c1ca20492b9af4228a414edd25f1006baace220e4ca771288e0f38d6cbf253ae4e9d39aaf4b881600b0d65e518e7d94891837ee9a0c6a723aac0f4d2b7bf4a65b36bd1fe636aa49c632"),
                FollowerData("뚱이", "안녕하세요", "https://img.insight.co.kr/static/2020/08/12/700/fyzvinle3b068ce501hq.jpg"),
                FollowerData("집게사장", "안녕하세요", "https://pbs.twimg.com/media/D8RITHlV4AAb1iG.jpg")
            )
        )
        follwerAdapter.notifyDataSetChanged()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

