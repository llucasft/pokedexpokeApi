package com.example.pokedex_pokeapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_pokeapi.R
import com.example.pokedex_pokeapi.model.Pokemon
import com.example.pokedex_pokeapi.model.PokemonType
import com.example.pokedex_pokeapi.ui.adapter.PokemonAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            1,
            "Charmander",
            listOf(
                (
                        PokemonType("Fire"))
            )
        )
        val pokemons = listOf(
            charmander, charmander, charmander, charmander, charmander
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}