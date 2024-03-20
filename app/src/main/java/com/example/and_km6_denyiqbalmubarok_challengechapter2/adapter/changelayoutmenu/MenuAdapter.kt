package com.example.and_km6_denyiqbalmubarok_challengechapter2.adapter.changelayoutmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.and_km6_denyiqbalmubarok_challengechapter2.base.ViewHolderBinder
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ItemMenuGridBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.databinding.ItemMenuListBinding
import com.example.and_km6_denyiqbalmubarok_challengechapter2.model.MenuDetail

class MenuAdapter(
    private val listener: OnItemClickedListener<MenuDetail>,
    private val listMode: Int = MODE_GRID
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this, object : DiffUtil.ItemCallback<MenuDetail>() {
            override fun areItemsTheSame(oldItem: MenuDetail, newItem: MenuDetail): Boolean {
                //membandingkan apakah item tersebut sama
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: MenuDetail, newItem: MenuDetail): Boolean {
                // yang dibandingkan adalah kontennya
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    fun submitData(data: List<MenuDetail>) {
        asyncDataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //membuat instance of view holder
        return if (listMode == MODE_GRID) MenuGridItemViewHolder(
            ItemMenuGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        ) else {
            MenuListItemViewHolder(
                ItemMenuListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<MenuDetail>).bind(asyncDataDiffer.currentList[position])
    }
}

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}