package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.api.APIInterface
import com.example.pokedex.data.repository.PokemonRepo


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerViewAdapter = RecyclerViewAdapter()
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerViewAdapter

        val retrofitService = APIInterface.create()
        val pokemonRepo = PokemonRepo(retrofitService)
        var viewModel = ViewModelProvider( this,
            MainActivityViewModelFactory(pokemonRepo))
            .get(MainActivityViewModel::class.java)

        //viewModel.pokemonList.observe(this,{
       //     recyclerViewAdapter.setPokemonListItem(it)
      //  })
        viewModel.pokemonListItem.observe( this,{
            recyclerViewAdapter.setPokemonList(it)
        })
        viewModel.loading.observe(this,{
            val pgBar = findViewById<ProgressBar>(R.id.progressBar)
            if(it){
                pgBar.visibility = View.VISIBLE
            }else{
                pgBar.visibility = View.GONE
            }
            pgBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.loadPokemonData()

       // var recyclerViewAdapter = RecyclerViewAdapter()
        //var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
       // recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = recyclerViewAdapter

        //get data from api
       // val apiInterface = APIInterface.create().getPokemons()

        //apiInterface.enqueue(object : Callback<PokemonAPIResult>{
        //    override fun onResponse(
        //        call: Call<PokemonAPIResult>,
        //        response: Response<PokemonAPIResult>
        //    ) {
         //       if(response.body() != null){
        //            recyclerViewAdapter.setPokemonList(response.body()!!)
        //        }
       //     }

       //     override fun onFailure(call: Call<PokemonAPIResult>, t: Throwable) {

        //    }

       // })



    }
}