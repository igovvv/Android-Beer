package com.example.beercafesv1.screens.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.Transformations
import com.example.beercafesv1.database.Favourite
import com.example.beercafesv1.database.FavouritesDatabase
import com.example.beercafesv1.database.FavouritesDatabaseDAO
import com.example.beercafesv1.models.BeerCafeItem
import kotlinx.coroutines.launch

class FavouritesViewModel(val database: FavouritesDatabaseDAO,
application: Application): AndroidViewModel(application){

    private var fav = MutableLiveData<Favourite>()

    private val allFavs = database.getAllFavs()

    val favsString = Transformations.map(allFavs) {
        //allFavs -> formatFavs(allFavs, application.resources)}


        val clearButtonVisible = Transformations.map(allFavs){
            it?.isNotEmpty()
    }

    //private var _showSnackbarEvent = MutableLiveData<Boolean>()
    //val showSnackbarEvent: LiveData<Boolean>
    //get() = _showSnackbarEvent

    //fun doneShowingSnackbar(){
        //_showSnackbarEvent.value = false
    }

    private suspend fun insert(favourite: Favourite){
        database.insert(favourite)
    }

}