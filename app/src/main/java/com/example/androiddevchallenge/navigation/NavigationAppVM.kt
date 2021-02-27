/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
enum class ShowScreen : AppState {
    HOME, DESCRIPTION
}

/**
 * [NavigationAppVM] this is a ViewModel that deals with navigation inside the main screens.
 *
 * @author Artem Gerasimov (artem241120@gmail.com)
 */
class NavigationAppVM : ViewModel() {
    private lateinit var navigation: MainNavigationVM
    var editPet: Pet? = null
        private set

    fun setNavigation(value: MainNavigationVM) {
        value.stack.add(ShowScreen.HOME)
        value.onBackList.add { onBackButtonClick(it) }
        navigation = value
    }

    private val state = mutableStateOf(ShowScreen.HOME)
    fun getState(): State<ShowScreen> = state

    fun moveDescription(pet: Pet) {
        editPet = pet
        navigation.stack.add(state.value)
        state.value = ShowScreen.DESCRIPTION
    }

    fun back() {
        navigation.back()
    }

    private fun onBackButtonClick(appState: AppState) {
        if (appState is ShowScreen) {
            state.value = appState
        }
    }
}
