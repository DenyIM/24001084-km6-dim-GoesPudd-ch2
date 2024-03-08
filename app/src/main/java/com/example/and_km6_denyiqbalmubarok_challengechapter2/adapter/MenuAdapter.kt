package com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ItemMenuBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.Menu
import com.example.and_km6_denyiqbalmubarok_challengechapter2.utils.toIndonesianFormat

class MenuAdapter: RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    class MenuViewHolder(private val binding: ItemMenuBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item: Menu) {
                    binding.tvMenuName.text = item.name
                    binding.ivMenuImage.setImageResource(item.image)
                    binding.tvMenuPrice.text = item.price.toIndonesianFormat()
                }
            }

    private val data = mutableListOf<Menu>()
    fun submitData(items: List<Menu>){
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(data[position])
    }
}