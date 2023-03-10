package com.example.pokedex_pokeapi.model

import java.util.*

data class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>
) {
    val formattedName = name.replaceFirstChar {
        if
            (it.isLowerCase()) it.titlecase(Locale.getDefault())
        else
            it.toString()
    }

    val formattedNumber = number.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${formattedNumber}.png"
}
