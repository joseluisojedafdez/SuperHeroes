package com.i4bchile.heropedia.view

import android.os.Bundle
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

        binding= FragmentDetailBinding.inflate(layoutInflater)

        viewModel.getHero(superId).observe(viewLifecycleOwner,{
            binding.tvHeroNameDetail.text=it.name
            binding.ivHeroImageLarge.load(it.images.md)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailAdapter=DetailAdapter(this,superId)
        binding.detailTabs.adapter=detailAdapter

    }

}