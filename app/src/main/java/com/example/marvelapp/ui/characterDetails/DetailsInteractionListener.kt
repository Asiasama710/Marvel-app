package com.example.marvelapp.ui.characterDetails

import com.example.marvelapp.data.response.characterResponse.Character
import com.example.marvelapp.ui.base.BaseInteractionListener

interface DetailsInteractionListener:BaseInteractionListener {
    fun onClickComics(character : Character)
    fun onClickSeries(character : Character)
}