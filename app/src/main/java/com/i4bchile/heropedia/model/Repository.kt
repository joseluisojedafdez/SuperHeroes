package com.i4bchile.heropedia.model

import android.util.Log

class Repository{

    private val database=SuperApplication.superDatabase!!
    val superList= database.superDao().getAllSuper()

    suspend fun getSuperHeroesfromApi(){

        val response=RetrofitClient.retrofitClient().getSuperHeroes()

        when(response.isSuccessful){

            true -> { response.body()?.let{

                    database.superDao().loadAllSuper(it)
                }}

            false-> {


            }
        }

    }
}