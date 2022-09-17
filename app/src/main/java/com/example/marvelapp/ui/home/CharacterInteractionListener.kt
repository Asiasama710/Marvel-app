package com.example.marvelapp.ui.home

import com.example.marvelapp.data.response.Character

interface CharacterInteractionListener {
    fun onClickCharacter(character: Character)
}