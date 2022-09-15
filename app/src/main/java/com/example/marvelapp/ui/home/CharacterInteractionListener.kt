package com.example.marvelapp.ui.home

import com.example.marvelapp.data.model.Character

interface CharacterInteractionListener {
    fun onClickCharacter(character: Character)
}