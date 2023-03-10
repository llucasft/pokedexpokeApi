package com.example.pokedex_pokeapi.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_pokeapi.R
import com.example.pokedex_pokeapi.model.Pokemon
import com.example.pokedex_pokeapi.ui.adapter.PokemonAdapter
import com.example.pokedex_pokeapi.ui.viewmodel.PokemonViewModel
import com.example.pokedex_pokeapi.ui.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvPokemons)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        val pokemonAdapter = PokemonAdapter(pokemons)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = pokemonAdapter

        pokemonAdapter.setOnItemClickListener(object : PokemonAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Pokemon ${pokemons[position]?.formattedName} clicado!",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(this@MainActivity, PokemonDetailsActivity::class.java)
                startActivity(intent)
            }
        })
    }
}