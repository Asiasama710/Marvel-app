package com.example.marvelapp.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.BR
import com.example.marvelapp.ui.home.CharacterInteractionListener


abstract class BaseAdapter<T>(
    var items: List<T>,
    private var listener: CharacterInteractionListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {


    abstract val layoutId: Int

    fun setItem(newItems: List<T>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun getItem() = items

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId , parent,false) )
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when(holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
        }
    }

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

}