package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FollowerFragmentBinding
import com.example.myapplication.databinding.RepositoryFragmentBinding

class RepositoryFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding: RepositoryFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RepositoryFragmentBinding.inflate(layoutInflater, container,false)

        repositoryAdapter = RepositoryAdapter()
        binding.rvRepository.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("안드로이드레파지토리", "안녕하세요안녕하세요안녕하세요"),
                RepositoryData("안드로이드레파지토리1", "안녕하세요"),
                RepositoryData("안드로이드레파지토리2", "안녕하세요"),
                RepositoryData("안드로이드레파지토리3", "안녕하세요")
            )
        )
        repositoryAdapter.notifyDataSetChanged()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
