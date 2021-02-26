package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.getPetList
import com.example.androiddevchallenge.ui.elements.screenViewPets.PetCard
import com.example.androiddevchallenge.ui.elements.screenViewPets.ScrollToTopButton
import com.example.androiddevchallenge.ui.screens.viewPets.ViewPetsVM
import kotlinx.coroutines.launch


@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ScreenViewPets(
    modifier: Modifier = Modifier
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
                    PetCard(pet = pet)
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
