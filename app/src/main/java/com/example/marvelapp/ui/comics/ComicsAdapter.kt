package com.example.marvelapp.ui.comics


import com.example.marvelapp.R
import com.example.marvelapp.data.model.Comics
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.BaseInteractionListener


class ComicsAdapter(items: List<Comics>, listener: BaseInteractionListener) :
    BaseAdapter<Comics>(items, listener) {
    override val layoutId = R.layout.item_comics
}
