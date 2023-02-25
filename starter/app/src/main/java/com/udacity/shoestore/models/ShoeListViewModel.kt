package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel :ViewModel(){


    val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = ArrayList()
    }

    fun addShoe(name: String, size: String, company: String, description: String) {
        var shoe: Shoe= Shoe(name, size, company, description)
        shoeList.value?.add(shoe)
        shoeList.value = shoeList.value

    }

    fun addDummyData(){
        addShoe("Nike Air Force 1", "10.0", "Nike", "Classic sneakers")
        addShoe("Reebok Club C 85", "9.5", "Reebok", "Retro style")
        addShoe("Vans Old Skool", "8.5", "Vans", "Skateboarding shoes")
        addShoe("New Balance 990v5", "9.5", "New Balance", "Comfortable and stylish")
        addShoe("Converse Chuck Taylor All Star", "7.5", "Converse", "Iconic design")
        addShoe("Adidas Ultra Boost 20", "9.0", "Adidas", "Comfortable running shoes")
        addShoe("Brooks Ghost 13", "8.5", "Brooks", "Responsive and cushioned")
        addShoe("Hoka One One Bondi 7", "10.5", "Hoka One One", "Maximum cushioning")
        addShoe("Mizuno Wave Rider 24", "9.5", "Mizuno", "Smooth and fast")
        addShoe("On Cloudswift", "8.0", "On", "Lightweight and responsive")
        addShoe("Salomon Speedcross 5", "10.0", "Salomon", "Aggressive trail running shoes")
        addShoe("Saucony Kinvara 12", "9.0", "Saucony", "Flexible and lightweight")

    }



}
