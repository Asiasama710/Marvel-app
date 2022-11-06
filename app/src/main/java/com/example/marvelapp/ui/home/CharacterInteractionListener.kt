package com.example.marvelapp.ui.home

import com.example.marvelapp.data.response.dto.CharacterDto
import com.example.marvelapp.ui.base.BaseInteractionListener

interface CharacterInteractionListener : BaseInteractionListener {
    fun onClickCharacter(characterId : Int)
}