package com.i4bchile.heropedia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.heropedia.model.Repository
import kotlinx.coroutines.launch

class SuperHeroesVM: ViewModel() {


    private val repository=Repository()
    val heroList=repository.superList

    init{

        viewModelScope.launch {
            repository.getSuperHeroesfromApi()
        }

    }



}