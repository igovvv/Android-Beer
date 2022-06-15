package com.example.beercafesv1.screens.cafelist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beercafesv1.models.BeerCafeItem

import com.example.beercafesv1.services.CafeApi

import kotlinx.coroutines.launch
import retrofit2.Call
import java.lang.Exception



enum class MarsApiStatus { LOADING, ERROR, DONE }

class CafeListViewModel : ViewModel() {

    private var _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() {
            return _error
        }
    private var _loadingFinished = MutableLiveData<Boolean>()
    val loadingFinished : LiveData<Boolean>
        get() {
            return _loadingFinished
        }
    private var _cafe = MutableLiveData<BeerCafeItem?>()
    val cafe : LiveData<BeerCafeItem?>
        get() {
            return _cafe
        }

    private var _cafes = MutableLiveData<List<BeerCafeItem>?>()
    val cafes: LiveData<List<BeerCafeItem>?> = _cafes

    init{
        _error.value = ""
        _loadingFinished.value = false
        viewModelScope.launch {
            try{
                _cafes .value = CafeApi.retrofitService.getCafeList()
                _loadingFinished.value = true
            } catch (e: Exception){
                _error.value = e.localizedMessage
                _cafes.value = listOf()
            }
        }

    }
    fun onCafeClicked(cafeItem: BeerCafeItem){
        _cafe.value = cafeItem
    }

    fun navigateToDetailFinished() {
        _cafe.value = null
    }
}