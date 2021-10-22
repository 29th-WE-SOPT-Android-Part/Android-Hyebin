package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemFollowerListBinding


class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val userList = mutableListOf<FollowerData>()

    class FollowerViewHolder(private val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: FollowerData) {
            binding.tvName.text = data.name
            binding.tvIntroduction.text = data.introduction
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
}