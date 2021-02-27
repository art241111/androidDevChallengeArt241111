package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pet

/**
 * Enum class describing possible screens.
 *
 * @author Artem Gerasimov (artem241120@gmail.com)
 */
enum class ShowScreen: AppState {
    HOME, DESCRIPTION
}

/**
 * [NavigationAppVM] this is a ViewModel that deals with navigation inside the main screens.
 *
 * @author Artem Gerasimov (artem241120@gmail.com)
 */
class NavigationAppVM: ViewModel() {
    private lateinit var navigation: MainNavigationVM
    var editPet: Pet? = null
    private set

    fun setNavigation(value: MainNavigationVM){
        value.stack.add(ShowScreen.HOME)
        value.onBackList.add{onBackButtonClick(it)}
        navigation = value
    }

    private val state = mutableStateOf(ShowScreen.HOME)
    fun getState() : State<ShowScreen> = state

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