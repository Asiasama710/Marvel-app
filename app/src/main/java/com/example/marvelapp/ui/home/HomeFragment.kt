package com.example.marvelapp.ui.home


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.characterDetails.DetailsCharacterFragmentDirections
import com.example.marvelapp.utilities.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleAdapterWithRecyclerView()
        handleEvents()
    }

    private fun handleAdapterWithRecyclerView() {
        val adapter = CharacterAdapter(mutableListOf(), viewModel)
        binding.itemRecyclerView.adapter = adapter
    }

    private fun handleEvents() {
        viewModel.navigateToDetails.observeEvent(viewLifecycleOwner) {
            navigateToDetails(it)
        }
    }

    private fun navigateToDetails(id: Int) {
        requireView()
            .findNavController()
            .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsCharacterFragment(id))
    }


}