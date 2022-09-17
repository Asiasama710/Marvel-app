package com.example.marvelapp.ui.home


import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment() : BaseFragment<FragmentHomeBinding>() {
    override val layoutIdFragment  = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    override fun setup() {

        val adapter = CharacterAdapter(mutableListOf() ,viewModel)
        binding.itemRecyclerView.adapter = adapter
        GlobalScope.launch( Dispatchers.Main) {
            Toast.makeText(context ,viewModel.listOfCharacter.value.toString() , Toast.LENGTH_SHORT).show()


        }


    }


}