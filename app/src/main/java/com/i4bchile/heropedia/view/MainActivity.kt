package com.i4bchile.heropedia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.i4bchile.heropedia.R
import com.i4bchile.heropedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.
        beginTransaction().
        replace(R.id.fc_container,ListFragment()).
        addToBackStack("back").
        commit()


        setContentView(binding.root)




    }
}

