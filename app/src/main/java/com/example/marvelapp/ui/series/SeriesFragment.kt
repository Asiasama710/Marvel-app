package com.example.marvelapp.ui.series

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentSeriesBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.comics.ComicsFragmentArgs
import com.example.marvelapp.ui.home.CharacterAdapter

class SeriesFragment : BaseFragment<FragmentSeriesBinding>() {
    override val layoutIdFragment  = R.layout.fragment_series
    override val viewModel: SeriesViewModel by viewModels()

    private val args : SeriesFragmentArgs by navArgs()

    override fun setup() {

        val adapter = SeriesAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter

        viewModel.getCharacterId(args.characterid)
        Log.i("qwe",viewModel.getCharacterId(args.characterid).toString())

    }

}