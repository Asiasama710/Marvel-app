package com.example.marvelapp.ui.characterDetails

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterDetailsBinding
import com.example.marvelapp.ui.base.BaseFragment

class DetailsCharacterFragment : BaseFragment<FragmentCharacterDetailsBinding>() {
    override val layoutIdFragment = R.layout.fragment_character_details
    override val viewModel: DetailsCharacterViewModel by viewModels ()

    private val args :DetailsCharacterFragmentArgs by navArgs()

    override fun setup() {
        viewModel.getCharacterId(args.characterid)
        Log.i("qwe",viewModel.getCharacterId(args.characterid).toString())
    }


}