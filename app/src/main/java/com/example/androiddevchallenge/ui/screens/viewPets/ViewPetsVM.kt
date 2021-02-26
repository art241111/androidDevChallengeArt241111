package com.example.androiddevchallenge.ui.screens.viewPets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.getPetList

class ViewPetsVM: ViewModel() {
    private val _pets: MutableLiveData<List<Pet>> = MutableLiveData(getPetList())
    val pets: LiveData<List<Pet>>
        get() = _pets
}