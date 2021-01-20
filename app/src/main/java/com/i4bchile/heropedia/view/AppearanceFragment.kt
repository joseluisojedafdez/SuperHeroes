package com.i4bchile.heropedia.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.i4bchile.heropedia.databinding.FragmentAppearanceBinding
import com.i4bchile.heropedia.databinding.FragmentPowStatsBinding
import com.i4bchile.heropedia.viewmodel.SuperHeroesVM

class AppearanceFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentAppearanceBinding
    private val viewModel: SuperHeroesVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAppearanceBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            var heigthValue="Unknown"
            if (!it.appearance.height[1].equals("0 cm")){
                heigthValue=it.appearance.height[1]
            }
            var weightValue="Unknown"
            if(!it.appearance.weight[1].equals("0 kg")){
                weightValue=it.appearance.weight[1]
            }
            binding.tvHeigthValue.text=heigthValue
            binding.tvWeightValue.text=weightValue
            binding.tvGenderValue.text=it.appearance.gender
            binding.tvRaceValue.text=it.appearance.race
            binding.tvEyeValue.text=it.appearance.eyeColor
            binding.tvHairValue.text=it.appearance.hairColor
        })


        return binding.root
    }


}