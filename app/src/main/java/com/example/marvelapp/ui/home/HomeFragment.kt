package com.example.marvelapp.ui.home


import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.utilities.observeEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment() : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment  = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    override fun setup() {

        val adapter = CharacterAdapter(mutableListOf() ,viewModel)
        binding.itemRecyclerView.adapter = adapter
        handleObserverEvent()
    }

    private fun handleObserverEvent() {
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