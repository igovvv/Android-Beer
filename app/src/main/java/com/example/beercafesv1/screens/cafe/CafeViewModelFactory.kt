package com.example.beercafesv1.screens.cafe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beercafesv1.models.BeerCafeItem

class CafeViewModelFactory(private val cafe: BeerCafeItem): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CafeViewModel::class.java)){
            return CafeViewModel(cafe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}