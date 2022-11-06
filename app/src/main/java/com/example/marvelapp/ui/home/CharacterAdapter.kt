package com.example.marvelapp.ui.home


import com.example.marvelapp.R
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.data.response.dto.CharacterDto


class CharacterAdapter(items: List<CharacterDto>, itemListener: CharacterInteractionListener) :
    BaseAdapter<CharacterDto>(items, itemListener) {
    override val layoutId = R.layout.item_character
}
