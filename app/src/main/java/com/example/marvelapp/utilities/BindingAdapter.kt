package com.example.marvelapp.utilities

import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.ui.base.BaseAdapter


@BindingAdapter(value = ["app:src"])
fun setImage(view: ImageView, id : Int?){
    id?.let { view.setImageResource(it) }
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if(items != null){
        (view.adapter  as BaseAdapter<T>?)?.setItem(items)
    }else{
        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())
    }
}