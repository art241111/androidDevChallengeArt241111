package com.example.androiddevchallenge.ui.screens.viewPets

import androidx.compose.animation.*
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
