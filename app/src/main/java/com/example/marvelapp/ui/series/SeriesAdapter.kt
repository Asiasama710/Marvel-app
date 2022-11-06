package com.example.marvelapp.ui.series


import com.example.marvelapp.R
import com.example.marvelapp.data.response.dto.SeriesDto
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.BaseInteractionListener


class SeriesAdapter(items: List<SeriesDto>, listener: BaseInteractionListener) :
    BaseAdapter<SeriesDto>(items, listener) {
    override val layoutId = R.layout.item_series
}
