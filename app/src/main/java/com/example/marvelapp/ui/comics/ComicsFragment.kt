package com.example.marvelapp.ui.comics

import androidx.fragment.app.viewModels
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentComicsBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.home.CharacterAdapter

class ComicsFragment : BaseFragment<FragmentComicsBinding>() {
    override val layoutIdFragment  = R.layout.fragment_comics
    override val viewModel: ComicsViewModel by viewModels()
    override fun setup() {
        val adapter = ComicsAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter
    }

}