package com.example.androiddevchallenge.navigation

import androidx.lifecycle.ViewModel
import java.util.*

interface AppState

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