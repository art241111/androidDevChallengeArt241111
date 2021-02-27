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
