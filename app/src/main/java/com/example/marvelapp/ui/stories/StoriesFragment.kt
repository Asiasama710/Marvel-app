package com.example.marvelapp.ui.stories


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentSeriesBinding
import com.example.marvelapp.databinding.FragmentStoriesBinding
import com.example.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoriesFragment : BaseFragment<FragmentStoriesBinding>() {
    override val layoutIdFragment  = R.layout.fragment_stories
    override val viewModel: StoriesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleAdapterWithRecyclerView()
    }

    private fun handleAdapterWithRecyclerView(){
        val adapter = StoriesAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter

    }

}