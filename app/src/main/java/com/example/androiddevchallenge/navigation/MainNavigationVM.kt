package com.example.androiddevchallenge.navigation

import androidx.lifecycle.ViewModel
import java.util.*

/**
 * Interface marker for enum classes that describe application screens.
 *
 * @author Artem Gerasimov (artem241120@gmail.com)
 */
interface AppState

/**
 * [MainNavigationVM] is a viewModel that stores the state of the screen in the stack.
 * It is also possible to track the click on the "back" button.
 * This class is the main one for navigation in the app.
 *
 * @author Artem Gerasimov (artem241120@gmail.com)
 */
class MainNavigationVM: ViewModel() {
    val stack = Stack<AppState>()
    val onBackList: MutableList<(AppState) -> Unit> = mutableListOf()

    fun back(): Boolean{
        return if(stack.size == 1){
            true
        } else {
            val newState = stack.pop()

            onBackList.forEach {
                it(newState)
            }

            false
        }
    }

    fun onBackButtonClick() = back()
}