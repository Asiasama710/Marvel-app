package com.example.marvelapp.ui.home


import androidx.fragment.app.viewModels
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment

class HomeFragment() : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment  = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    override fun setup() {

        val adapter = CharacterAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter
    }


}