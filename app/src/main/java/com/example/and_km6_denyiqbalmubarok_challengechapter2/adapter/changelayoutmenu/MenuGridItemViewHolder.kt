package com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.changelayoutmenu

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.and_km6_denyiqbalmubarok_challengechapter2.R
import com.example.and_km6_denyiqbalmubarok_challengechapter2.base.ViewHolderBinder
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ItemMenuGridBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.MenuDetail
import com.example.and_km6_denyiqbalmubarok_challengechapter2.utils.toIndonesianFormat

class MenuGridItemViewHolder(
    private val binding: ItemMenuGridBinding,
    private val listener: OnItemClickedListener<MenuDetail>
): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<MenuDetail> {
    override fun bind(item: MenuDetail) {
        item.let {
            binding.ivMenuImage.load(it.image) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvMenuName.text = it.name
            binding.tvMenuPrice.text = it.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}