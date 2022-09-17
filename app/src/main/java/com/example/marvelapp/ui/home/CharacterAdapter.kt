package com.example.marvelapp.ui.home


import com.example.marvelapp.R
import com.example.marvelapp.ui.base.BaseAdapter
import com.example.marvelapp.data.response.Character


class CharacterAdapter(items: List<Character>, itemListener: CharacterInteractionListener) :
    BaseAdapter<Character>(items, itemListener) {
    override val layoutId = R.layout.item_character
}
