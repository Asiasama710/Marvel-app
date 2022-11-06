package com.example.marvelapp.utilities

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.data.State
import com.example.marvelapp.ui.base.BaseAdapter
import java.text.SimpleDateFormat
import java.util.*
import java.util.Collections.rotate


@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.isVisible = (state is State.Success)
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    view.isVisible = (state is State.Error)
}


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.isVisible = (state is State.Loading)
}

@BindingAdapter(value = ["app:imageurl"])
fun setImage(view: ImageView, url : String?){
    Glide.with(view).load(url).centerCrop().placeholder(R.drawable.rotate).error(R.drawable.no_image).into(view)
}

@BindingAdapter(value = ["app:modifiedDate"])
fun setModifiedDate(view: TextView, date: Date?) {
    val formatDate = SimpleDateFormat("yyyy",Locale("en"))
    date?.let {
        view.text = formatDate.format(it).toString()
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if(items != null){
        (view.adapter  as BaseAdapter<T>?)?.setItem(items)
    }else{
        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())
    }
}
