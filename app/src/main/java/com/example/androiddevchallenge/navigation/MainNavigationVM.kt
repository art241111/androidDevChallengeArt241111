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

import androidx.lifecycle.ViewModel
import java.util.Stack

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
class MainNavigationVM : ViewModel() {
    val stack = Stack<AppState>()
    val onBackList: MutableList<(AppState) -> Unit> = mutableListOf()

    fun back(): Boolean {
        return if (stack.size == 1) {
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
