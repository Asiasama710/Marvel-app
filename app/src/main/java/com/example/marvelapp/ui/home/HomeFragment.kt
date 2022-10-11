package com.example.marvelapp.ui.home


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.utilities.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment  = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        handleAdapterWithRecyclerView()
        navigateToDetails()

    }



    private fun handleAdapterWithRecyclerView(){
        val adapter = CharacterAdapter(mutableListOf() ,viewModel)
        binding.itemRecyclerView.adapter = adapter
    }

    private fun navigateToDetails() {
        viewModel.apply {
            navigateToDetails.observeEvent(this@HomeFragment) {
                if(it!=null){
                  view?.findNavController()
                  ?.navigate(HomeFragmentDirections.actionHomeFragmentToDetailsCharacterFragment(it))
                }
            }
        }
    }


}