package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemFollowerListBinding
import com.example.myapplication.databinding.ItemRepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    val repositoryList = mutableListOf<RepositoryData>()

    class RepositoryViewHolder(private val binding : ItemRepositoryListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: RepositoryData) {
            binding.tvTitle.text = data.title
            binding.tvContent.text = data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    override fun getItemCount(): Int = repositoryList.size
}