package com.i4bchile.superheroes.model

import android.util.Log

class Repository{

    suspend fun getSuperHeroesfromApi(){

        val response=RetrofitClient.retrofitClient().getSuperHeroes()

        when(response.isSuccessful){

            true -> { response.body()?.let{
                    Log.d("Repo", "getSuperHeroes con :${it.size} heroes ")
                }}

            false-> {
                Log.d("Repo", "getSuperHeroes: ${response.errorBody()}")

            }
        }

    }
}