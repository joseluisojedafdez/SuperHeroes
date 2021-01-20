package com.i4bchile.heropedia.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.i4bchile.heropedia.databinding.FragmentDetailBinding
import com.i4bchile.heropedia.viewmodel.SuperHeroesVM

class DetailFragment(id:Int): Fragment() {
    private lateinit var binding:FragmentDetailBinding
    private val viewModel:SuperHeroesVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("DetailFragment", "onCreateView: idHero: $superId")
        binding= FragmentDetailBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner,{
            binding.tvHeroNameDetail.text=it.name
            binding.tvIntelligenceValue.text=it.powerstats.intelligence.toString()
            binding.ivHeroImageLarge.load(it.images.md)
        })





        return binding.root
    }

}