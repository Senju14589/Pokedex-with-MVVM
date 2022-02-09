package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.data.api.model.PokemonAPIResult
import com.example.pokedex.data.api.model.Result
import com.example.pokedex.data.model.ListItem

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var pokemonListItem : List<ListItem> = listOf()
    fun setPokemonList(data: List<ListItem>){
        this.pokemonListItem = data
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvPokeName: TextView = itemView.findViewById(R.id.tvPokemonName)
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvPokeName.text = this.pokemonListItem.get(position).name
        Glide.with(holder.imageView.context).load(this.pokemonListItem.get(position).imgUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return this.pokemonListItem.size
    }


}