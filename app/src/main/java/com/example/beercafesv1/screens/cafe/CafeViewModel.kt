package com.example.beercafesv1.screens.cafe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beercafesv1.models.BeerCafeItem

class CafeViewModel(val __cafe: BeerCafeItem) : ViewModel(){
    private var _cafe = MutableLiveData<BeerCafeItem>()
    val cafe : LiveData<BeerCafeItem>

    get(){
        return _cafe
    }

    init {
        _cafe.value = __cafe
    }
}