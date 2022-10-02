package com.example.marvelapp.ui.characterDetails

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




    override fun onStart() {
        super.onStart()
        viewModel.getCharacterId(args.characterid)
        goToComics()
        goToSeries()
    }


    private fun goToComics() {
        viewModel.apply {
            navigateToComicsList.observeEvent(this@DetailsCharacterFragment) {
                if(it!=null){
                    view?.findNavController()
                        ?.navigate(DetailsCharacterFragmentDirections.actionDetailsCharacterFragmentToComicsFragment(it))
                }
            }
        }
    }
    private fun goToSeries() {
        viewModel.apply {
            navigateToSeriesList.observeEvent(this@DetailsCharacterFragment) {
                if(it!=null){
                    view?.findNavController()
                        ?.navigate(DetailsCharacterFragmentDirections.actionDetailsCharacterFragmentToSeriesFragment(it))
                }
            }
        }
    }



}