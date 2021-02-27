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
package com.example.androiddevchallenge.ui.screens.viewPets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.elements.screenViewPets.PetCard
import com.example.androiddevchallenge.ui.elements.screenViewPets.ScrollToTopButton
import kotlinx.coroutines.launch

/**
 * A screen that shows a list of all the animals.
 *
 *  @author Artem Gerasimov (artem241120@gmail.com)
 */
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ScreenViewPets(
    modifier: Modifier = Modifier,
    goDescription: (Pet) -> Unit,
) {
    Box(modifier) {
        val petsVM = viewModel<ViewPetsVM>()
        val pets = petsVM.pets.observeAsState()

        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            cells = GridCells.Adaptive(200.dp),
            state = listState,
            contentPadding = PaddingValues(bottom = 60.dp, top = 15.dp, start = 10.dp, end = 10.dp),
        ) {
            if (pets.value != null) {
                items(pets.value!!) { pet ->
                    PetCard(
                        modifier = Modifier.clickable {
                            goDescription(pet)
                        },
                        pet = pet
                    )
                }
            }
        }

        val showButton = listState.firstVisibleItemIndex > 0
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                modifier = Modifier,
                onClick = {
                    scope.launch {
                        listState.scrollToItem(0)
                    }
                }
            )
        }
    }
}
