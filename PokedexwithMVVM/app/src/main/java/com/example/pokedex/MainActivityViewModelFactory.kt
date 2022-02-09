package com.example.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.data.repository.PokemonRepo

class MainActivityViewModelFactory constructor(private val repo: PokemonRepo) : ViewModelProvider.Factory{
      override  fun <T : ViewModel?> create(modelClass: Class<T>): T {
          return if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
              MainActivityViewModel(this.repo) as T
          }else{
              throw IllegalAccessException("ViewModel Not Found")
          }
      }

}