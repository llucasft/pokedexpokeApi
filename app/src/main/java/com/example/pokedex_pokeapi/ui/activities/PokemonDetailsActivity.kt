package com.example.pokedex_pokeapi.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pokedex_pokeapi.R

class PokemonDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        // TODO: Mandar o nome do pokemon clicado via Intent.putExtra
        var pokemonName = findViewById<TextView>(R.id.pokemonDetailsName)
    }
}