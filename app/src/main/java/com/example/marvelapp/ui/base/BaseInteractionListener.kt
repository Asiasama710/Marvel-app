package com.example.marvelapp.ui.base

import com.example.marvelapp.data.model.Character

interface BaseInteractionListener{
    fun onClickCharacter(character: Character)
}