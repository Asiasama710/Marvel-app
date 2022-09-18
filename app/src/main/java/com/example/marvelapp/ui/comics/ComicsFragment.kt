package com.example.marvelapp.ui.comics

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentComicsBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.ui.characterDetails.DetailsCharacterFragmentArgs
import com.example.marvelapp.ui.home.CharacterAdapter

class ComicsFragment : BaseFragment<FragmentComicsBinding>() {
    override val layoutIdFragment  = R.layout.fragment_comics
    override val viewModel: ComicsViewModel by viewModels()

    private val args :ComicsFragmentArgs by navArgs()


    override fun setup() {
        viewModel.getCharacterId(args.characterid)
        Log.i("qwe",viewModel.getCharacterId(args.characterid).toString())

        val adapter = ComicsAdapter(mutableListOf(),viewModel)
        binding.itemRecyclerView.adapter = adapter


    }

}