package com.example.androiddevchallenge.ui.screens.petDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.elements.screenViewPetDetail.TextHeader
import com.example.androiddevchallenge.ui.theme.green500

@Composable
fun ScreenViewPetDetail(
    modifier: Modifier = Modifier,
    pet: MutableState<Pet?>
) {
    Surface {
        Box(modifier = modifier.fillMaxSize()) {
            if (pet.value != null) {
                Column(
                    modifier = Modifier.verticalScroll(ScrollState(0))
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        painter = painterResource(id = pet.value!!.image),
                        contentDescription = "${stringResource(id = R.string.pet_list_pet_name)} " +
                                pet.value!!.name,
                        contentScale = ContentScale.Crop
                    )

                    TextHeader(
                        modifier = Modifier.fillMaxWidth(),
                        text = pet.value!!.name
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${pet.value!!.year} years",
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                        text = pet.value!!.description,
                        textAlign = TextAlign.Justify,
                        fontSize = 16.sp
                    )
                }
            }

            ButtonBack(
                modifier = Modifier.align(Alignment.TopStart).padding(20.dp),
                onClick = {
                    pet.value = null
                },
            )

        }
    }
}

@Composable
fun ButtonBack(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.padding(bottom = 10.dp),
        shape = RoundedCornerShape(50),
        elevation = 3.dp
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "<",
                tint = green500
            )
        }
    }
}
