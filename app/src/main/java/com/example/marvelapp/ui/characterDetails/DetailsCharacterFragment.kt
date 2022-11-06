package com.example.marvelapp.ui.characterDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterDetailsBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.utilities.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsCharacterFragment : BaseFragment<FragmentCharacterDetailsBinding>() {

    private val args :DetailsCharacterFragmentArgs by navArgs()

    override val layoutIdFragment = R.layout.fragment_character_details
    override val viewModel: DetailsCharacterViewModel by viewModels ()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
        viewModel.getCharacterId(args.characterid)
    }


    private fun handleEvents()  {
        viewModel.apply {
            navigateToComicsList.observeEvent(viewLifecycleOwner) {
                Log.i("MALT","navigat to comic ${it}")
                navigateToComics(it)
                }
            navigateToSeries.observeEvent(viewLifecycleOwner) {
                navigateToSeries(it)
            }
            navigateToStories.observeEvent(viewLifecycleOwner) {
                Log.i("MALT","navigat to Storis ${it}")
                navigateToStories(it)
            }
        }

    }

    private fun navigateToComics(id: Int){
        Log.i("MALT","in details fragment comic id  ${id}")
        requireView()
            .findNavController()
            .navigate(DetailsCharacterFragmentDirections.actionDetailsCharacterFragmentToComicsFragment(id))
    }

    private fun navigateToSeries(id: Int){
        requireView()
            .findNavController()
            .navigate(DetailsCharacterFragmentDirections.actionDetailsCharacterFragmentToSeriesFragment(id))
    }
    private fun navigateToStories(id: Int){
        Log.i("MALT","in details fragment stories id ${id}")
        requireView()
            .findNavController()
            .navigate(DetailsCharacterFragmentDirections.actionDetailsCharacterFragmentToStoriesFragment(id))

    }


}