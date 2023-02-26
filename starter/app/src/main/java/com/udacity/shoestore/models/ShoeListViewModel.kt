package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel :ViewModel(){


    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    fun addShoe(shoe: Shoe) {
        if (_shoesList.value == null) {
            _shoesList.value = mutableListOf(shoe)
        } else {
            _shoesList.value?.add(shoe)
        }
    }

}
