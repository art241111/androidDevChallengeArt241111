package com.example.androiddevchallenge.ui.elements.screenViewPetDetail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

/**
 * Text header.
 *
 *  @author Artem Gerasimov (artem241120@gmail.com)
 */
@Composable
fun TextHeader(
    modifier: Modifier = Modifier,
    text: String,
    fontFamily: FontFamily? = MaterialTheme.typography.h1.fontFamily,
    fontSize: TextUnit = MaterialTheme.typography.h1.fontSize
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h1,
        fontFamily = fontFamily,
        fontSize = fontSize,
        textAlign = TextAlign.Center
    )
}