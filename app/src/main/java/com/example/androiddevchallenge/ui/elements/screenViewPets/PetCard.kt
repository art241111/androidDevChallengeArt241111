package com.example.androiddevchallenge.ui.elements.screenViewPets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.theme.green200_alpha80

/**
 * A card that displays the characteristics of the animal.
 *
 *  @author Artem Gerasimov (artem241120@gmail.com)
 */
@Composable
internal fun PetCard(
    modifier: Modifier = Modifier,
    pet: Pet
) {
    Surface(
        modifier = modifier
            .size(width = 500.dp, height = 200.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = pet.image),
                contentDescription = "${stringResource(id = R.string.pet_list_pet_name)} ${pet.name}",
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier.fillMaxWidth()
                    .background(color = green200_alpha80)
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 5.dp),
                text = pet.name,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}