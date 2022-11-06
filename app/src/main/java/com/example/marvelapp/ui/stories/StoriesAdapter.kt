package com.example.marvelapp.ui.stories


import com.example.marvelapp.R
import com.example.marvelapp.data.response.dto.SeriesDto
import com.example.marvelapp.data.response.dto.StoriesDto
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.BaseInteractionListener


class StoriesAdapter(items: List<StoriesDto>, listener: BaseInteractionListener) :
    BaseAdapter<StoriesDto>(items, listener) {
    override val layoutId = R.layout.item_stories
}
