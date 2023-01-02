package com.example.pokedex_pokeapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_pokeapi.R
import com.example.pokedex_pokeapi.model.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) {
            val image = itemView.findViewById<ImageView>(R.id.pokemonImage)
            val number = itemView.findViewById<TextView>(R.id.tvPokemonIdNumber)
            val name = itemView.findViewById<TextView>(R.id.tvPokemonName)
            val type1 = itemView.findViewById<TextView>(R.id.tvType1)
            val type2 = itemView.findViewById<TextView>(R.id.tvType2)

            // TODO: Load image with glide

            number.text = "N° ${item.formattedNumber}"
            name.text = item.name
            type1.text = item.types[0].name

            if (item.types.size > 1){
                type2.visibility = View.VISIBLE
                type2.text = item.types[1].name
            }
            else {
                type2.visibility = View.GONE
            }
        }
    }
}