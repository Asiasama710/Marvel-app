package com.example.marvelapp.ui.characterDetails

import androidx.fragment.app.viewModels
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterDetailsBinding
import com.example.marvelapp.ui.base.BaseFragment

class DetailsCharacterFragment : BaseFragment<FragmentCharacterDetailsBinding>() {
    override val layoutIdFragment = R.layout.fragment_character_details
    override val viewModel: DetailsCharacterViewModel by viewModels ()

    override fun setup() {

    }


}