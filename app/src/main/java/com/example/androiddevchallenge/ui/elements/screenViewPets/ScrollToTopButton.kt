package com.example.androiddevchallenge.ui.elements.screenViewPets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.green500

@Composable
internal fun ScrollToTopButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier.padding(bottom = 10.dp),
        shape = RoundedCornerShape(50),
        elevation = 3.dp
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowUp,
                contentDescription = "^",
                tint = green500
            )
        }
    }
}
