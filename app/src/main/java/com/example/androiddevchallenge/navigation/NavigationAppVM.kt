package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pet


enum class ShowScreen: AppState {
    HOME, DESCRIPTION
}

class NavigationAppVM: ViewModel() {
    private lateinit var navigation: MainNavigationVM
    var editPet: Pet? = null
    private set(pet: Pet?){
        field = pet
    }

    fun setNavigation(value: MainNavigationVM){
        value.stack.add(ShowScreen.HOME)
        value.onBackList.add{onBackButtonClick(it)}
        navigation = value
    }

    private val state = mutableStateOf(ShowScreen.HOME)
    fun getState() : State<ShowScreen> = state

    fun moveHome(){
        navigation.stack.clear()
        state.value = ShowScreen.HOME
    }

    fun moveDescription(pet: Pet){
        editPet = pet
        navigation.stack.add(state.value)
        state.value = ShowScreen.DESCRIPTION
    }

    fun back() {
        navigation.back()
    }

    private fun onBackButtonClick(appState: AppState){
        if (appState is ShowScreen) {
            state.value = appState
        }
    }
}