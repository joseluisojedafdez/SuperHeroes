package com.i4bchile.superheroes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.i4bchile.superheroes.R
import com.i4bchile.superheroes.databinding.ActivityMainBinding
import com.i4bchile.superheroes.model.Repository
import com.i4bchile.superheroes.viewmodel.SuperHeroesVM

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val viewModel: SuperHeroesVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel.doSomething()
        setContentView(binding.root)




    }
}

