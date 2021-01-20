package com.i4bchile.heropedia.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailAdapter(fragment: Fragment, superId: Int): FragmentStateAdapter(fragment) {

    val id=superId
    override fun getItemCount()=4


    override fun createFragment(position: Int): Fragment {
        var fragment=Fragment()
        when(position){
            0-> {fragment=PowStatFragment(id)} // open fragment with PowerStats
            1-> {fragment=AppearanceFragment(id)}// open fragment with Appearance
            2-> {fragment=BioFragment(id)}// open fragment with Bio
            3-> {fragment=OtherFragment(id)}// open Fragment with Other
        }
        return fragment
    }
}