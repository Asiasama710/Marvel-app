package com.example.marvelapp.ui.home

import com.example.marvelapp.data.response.characterResponse.Character
import com.example.marvelapp.ui.base.BaseInteractionListener

interface CharacterInteractionListener : BaseInteractionListener {
    fun onClickCharacter(character : Character)
}