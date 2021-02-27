package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.navigation.MainNavigationVM
import com.example.androiddevchallenge.navigation.NavigationAppVM
import com.example.androiddevchallenge.navigation.ShowScreen
import com.example.androiddevchallenge.ui.screens.petDetail.ScreenViewPetDetail
import com.example.androiddevchallenge.ui.screens.viewPets.ScreenViewPets

/**
 * The initial graphic screen, which is used for
 * navigation depending on the state in [NavigationAppVM].
 *
 * @author Artem Gerasimov (artem241120@gmail.com)
 */
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun NavigationAppScreen(
    mainNavigationVM: MainNavigationVM,
) {
    val navigationApp = viewModel<NavigationAppVM>()
    navigationApp.setNavigation(mainNavigationVM)

    val state = navigationApp.getState()

    DefaultScreenBody {
        AnimatedVisibility(
            visible = state.value == ShowScreen.HOME,
            enter = expandVertically(),
            exit = shrinkOut(),
        ) {
            ScreenViewPets(
                goDescription = { pet ->
                    navigationApp.moveDescription(pet)
                }
            )
        }

        AnimatedVisibility(
            visible = state.value == ShowScreen.DESCRIPTION,
            enter = expandVertically(),
            exit = shrinkOut(),
        ) {
            ScreenViewPetDetail(
                pet = navigationApp.editPet
            ) {
                navigationApp.back()
            }
        }
    }
}
