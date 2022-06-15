package com.example.beercafesv1.screens.cafelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beercafesv1.R
import com.example.beercafesv1.database.FavouritesDatabase
import com.example.beercafesv1.databinding.FragmentCafeListBinding
import com.example.beercafesv1.databinding.FragmentFavoritesBinding
import com.example.beercafesv1.screens.favourites.FavouritesViewModel
import com.example.beercafesv1.screens.favourites.FavouritesViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFavoritesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = FavouritesDatabase.getInstance(application).favouritesDatabaseDAO

        //val viewModelFactory = FavouritesViewModelFactory(dataSource, application)

        //val favouritesViewModel =
            //ViewModelProvider(this, viewModelFactory).get(FavouritesViewModel::class.java)

        //binding.favouritesViewModel = favouritesViewModel

        binding.setLifecycleOwner(this)

        //favouritesViewModel.showSnackBarEvent.observe(this, Observer{
            //if (it==true){
                //Snackbar.make(
                    //activity!!.findViewById(android.R.id.content),
                    //"All your data is gone forever",
                    //Snackbar.LENGTH_SHORT
                //).show()
                //favouritesViewModel.doneShowingSnackbar()
            //}
        //})

        return binding.root
    }




}
