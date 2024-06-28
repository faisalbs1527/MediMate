package com.example.medimate.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.medimate.ui.theme.MediMateTheme
import com.example.medimate.ui.theme.green80

@Composable
fun IconBox(
    modifier: Modifier = Modifier,
    colorContainer: Color,
    icon: ImageVector,
    colorIcon: Color,
    iconSize: Dp
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = colorContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon, contentDescription = "",
                tint = colorIcon,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Preview
@Composable
private fun ViewIconBox() {
    MediMateTheme {
        IconBox(modifier = Modifier.size(56.dp), green80, Icons.Filled.Add, Color.White, 40.dp)
    }
}