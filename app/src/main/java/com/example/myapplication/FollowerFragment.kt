package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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



        //ItemDecoration
        binding.rvFollower.addItemDecoration(Decoration(70,70,20, Color.BLACK))


        follwerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = follwerAdapter

        follwerAdapter.userList.addAll(
            listOf(
                FollowerData("이혜빈1", "안녕하세요"),
                FollowerData("이혜빈2", "안녕하세요"),
                FollowerData("이혜빈3", "안녕하세요"),
                FollowerData("이혜빈4", "안녕하세요")
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

