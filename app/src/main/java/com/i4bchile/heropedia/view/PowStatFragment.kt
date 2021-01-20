package com.i4bchile.heropedia.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.i4bchile.heropedia.databinding.FragmentPowStatsBinding
import com.i4bchile.heropedia.viewmodel.SuperHeroesVM

class PowStatFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentPowStatsBinding
    private val viewModel: SuperHeroesVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentPowStatsBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.rbIntelligence.rating=it.powerstats.intelligence/20.toFloat()
            binding.rbCombat.rating=it.powerstats.combat/20.toFloat()
            binding.rbDurability.rating=it.powerstats.durability/20.toFloat()
            binding.rbPower.rating=it.powerstats.power/20.toFloat()
            binding.rbSpeed.rating=it.powerstats.speed/20.toFloat()
            binding.rbStrength.rating=it.powerstats.strength/20.toFloat()

        })


        return binding.root
    }


}