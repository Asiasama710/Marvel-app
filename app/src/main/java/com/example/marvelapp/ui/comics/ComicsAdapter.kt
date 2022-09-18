package com.example.marvelapp.ui.comics


import com.example.marvelapp.R
import com.example.marvelapp.data.response.comicsResponse.Comic
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.BaseInteractionListener


class ComicsAdapter(items: List<Comic>, listener: BaseInteractionListener) :
    BaseAdapter<Comic>(items, listener) {
    override val layoutId = R.layout.item_comics
}
