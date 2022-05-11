package com.mansao.droidcafee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mansao.droidcafee.databinding.ItemListBinding

class ListDessertsAdapter(private val listDessert: ArrayList<Desserts>) :
    RecyclerView.Adapter<ListDessertsAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val desserts = listDessert[position]
        Glide.with(holder.itemView.context)
            .load(desserts.image)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_priority_high_24)
            .into(holder.binding.imgDessert)

        holder.binding.tvItemName.text = desserts.name
        holder.binding.tvItemDescription.text = desserts.description

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listDessert[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int = listDessert.size


    class ListViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallBack {
        fun onItemClicked(data: Desserts)
    }
}