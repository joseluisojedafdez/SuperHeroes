package com.i4bchile.heropedia.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.i4bchile.heropedia.databinding.ItemListSuperheroBinding
import com.i4bchile.heropedia.model.SuperHero

class SuperAdapter(val listener:OnItemClickListener): RecyclerView.Adapter<SuperVH>() {

    private val superList=mutableListOf<SuperHero>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperVH {
        val binding=ItemListSuperheroBinding.inflate(LayoutInflater.from(parent.context))
        return SuperVH(binding)
    }

    override fun onBindViewHolder(holder: SuperVH, position: Int) {
        val superHero=superList[position]
        holder.itemView.setOnClickListener{
            listener.onClick(superHero.id)
        }
        holder.bind(superHero)


    }

    override fun getItemCount(): Int {
           return superList.size
    }

    fun updateList(list:List<SuperHero>){
        superList.clear()
        superList.addAll(list)
        notifyDataSetChanged()
    }
}

class SuperVH(private val binding:ItemListSuperheroBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(superHero: SuperHero) {
        binding.tvHeroName.text=superHero.name
        binding.imageView.load(superHero.images.sm)
        binding.tvHeroAlingment.text=superHero.biography.alignment.toUpperCase()
        binding.tvUniverse.text=superHero.biography.publisher

    }


}
