package com.example.marvelapp.ui.series

import androidx.fragment.app.viewModels
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentSeriesBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.home.CharacterAdapter

class SeriesFragment : BaseFragment<FragmentSeriesBinding>() {
    override val layoutIdFragment  = R.layout.fragment_series
    override val viewModel: SeriesViewModel by viewModels()
    override fun setup() {

        val adapter = SeriesAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter
    }

}