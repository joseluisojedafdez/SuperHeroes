package com.i4bchile.heropedia.model

import android.util.Log

class Repository{

    private val database=SuperApplication.superDatabase!!
    val superList= database.superDao().getAllSuper()

    suspend fun getSuperHeroesfromApi(){

        val response=RetrofitClient.retrofitClient().getSuperHeroes()

        when(response.isSuccessful){

            true -> { response.body()?.let{
                    Log.d("Repo", "getSuperHeroes con :${it.size} heroes ")
                    database.superDao().loadAllSuper(it)
                }}

            false-> {
                Log.d("Repo", "getSuperHeroes: ${response.errorBody()}")

            }
        }

    }
}