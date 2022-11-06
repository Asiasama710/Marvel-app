package com.example.marvelapp.ui.comics


import com.example.marvelapp.R
import com.example.marvelapp.data.response.dto.ComicDto
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.BaseInteractionListener


class ComicsAdapter(items: List<ComicDto>, listener: BaseInteractionListener) :
    BaseAdapter<ComicDto>(items, listener) {
    override val layoutId = R.layout.item_comics
}
