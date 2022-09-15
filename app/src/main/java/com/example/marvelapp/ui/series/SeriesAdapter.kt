package com.example.marvelapp.ui.series


import com.example.marvelapp.R
import com.example.marvelapp.data.model.Series
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.ui.base.BaseInteractionListener


class SeriesAdapter(items: List<Series>, listener: BaseInteractionListener) :
    BaseAdapter<Series>(items, listener) {
    override val layoutId = R.layout.item_series
}
