package com.i4bchile.superheroes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.superheroes.model.Repository
import kotlinx.coroutines.launch

class SuperHeroesVM: ViewModel() {
    fun doSomething() {
       //TODO: delete - > just to init the viewModel and test API
    }

    val repository=Repository()

    init{

        viewModelScope.launch {
            repository.getSuperHeroesfromApi()
        }

    }



}