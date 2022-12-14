package com.example.marvelapp.ui.comics

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentComicsBinding
import com.example.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : BaseFragment<FragmentComicsBinding>() {

    private val args: ComicsFragmentArgs by navArgs()

    override val layoutIdFragment = R.layout.fragment_comics
    override val viewModel: ComicsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleAdapterWithRecyclerView()
    }

    private fun handleAdapterWithRecyclerView() {
        val adapter = ComicsAdapter(mutableListOf(), viewModel)
        binding.itemRecyclerView.adapter = adapter
    }

}