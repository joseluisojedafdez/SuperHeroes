package com.i4bchile.heropedia.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.i4bchile.heropedia.databinding.FragmentListBinding
import com.i4bchile.heropedia.viewmodel.SuperHeroesVM

class ListFragment: Fragment() {

    private lateinit var binding:FragmentListBinding
    private val viewModel: SuperHeroesVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentListBinding.inflate(layoutInflater)
        val adapter=SuperAdapter()
        binding.rvHeroList.adapter=adapter
        binding.rvHeroList.layoutManager=GridLayoutManager(this.context,1)
        viewModel.heroList.observe(viewLifecycleOwner,{heroList -> heroList?.let{
            adapter.updateList(it)
        }
        })


        return binding.root
    }
}