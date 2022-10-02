package com.example.marvelapp.ui.series


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentSeriesBinding
import com.example.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : BaseFragment<FragmentSeriesBinding>() {
    override val layoutIdFragment  = R.layout.fragment_series
    override val viewModel: SeriesViewModel by viewModels()

    private val args : SeriesFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
        viewModel.getCharacterId(args.characterid)
        handleAdapterWithRecyclerView()
    }

    private fun handleAdapterWithRecyclerView(){
        val adapter = SeriesAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter

    }

}