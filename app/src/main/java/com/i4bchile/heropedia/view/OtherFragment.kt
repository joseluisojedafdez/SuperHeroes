package com.i4bchile.heropedia.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.i4bchile.heropedia.databinding.FragmentAppearanceBinding
import com.i4bchile.heropedia.databinding.FragmentBioBinding
import com.i4bchile.heropedia.databinding.FragmentOtherBinding
import com.i4bchile.heropedia.databinding.FragmentPowStatsBinding
import com.i4bchile.heropedia.viewmodel.SuperHeroesVM

class OtherFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentOtherBinding
    private val viewModel: SuperHeroesVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentOtherBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.tvWorkValue.text=it.work.occupation
            binding.tvBaseValue.text=it.work.base
            binding.tvGroupAffilValue.text=it.connections.groupAffiliation
            binding.tvRelativesValue.text=it.connections.relatives
        })


        return binding.root
    }


}