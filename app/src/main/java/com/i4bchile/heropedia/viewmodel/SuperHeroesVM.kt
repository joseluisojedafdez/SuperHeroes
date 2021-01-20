package com.i4bchile.heropedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.heropedia.model.Repository
import com.i4bchile.heropedia.model.SuperHero
import kotlinx.coroutines.launch

class SuperHeroesVM: ViewModel() {

    private val repository=Repository()
    val heroList=repository.superList


   fun getHero(superId: Int): LiveData<SuperHero> {

           return repository.getSuperHero(superId)


   }




    init{

        viewModelScope.launch {
            repository.getSuperHeroesfromApi()
        }

    }



}