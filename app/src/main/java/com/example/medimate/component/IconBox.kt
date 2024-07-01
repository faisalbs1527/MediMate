package com.example.medimate.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.ui.theme.MediMateTheme
import com.example.medimate.ui.theme.green80

@Composable
fun IconBox(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colorContainer: Color,
    iconPainter: Painter? = null,
    iconVector: ImageVector? = null,
    colorIcon: Color,
    iconSize: Dp
) {
    Card(
        modifier = modifier.clickable {
            onClick()
        },
        colors = CardDefaults.cardColors(containerColor = colorContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (iconPainter != null) {
                Icon(
                    iconPainter, contentDescription = "",
                    tint = colorIcon,
                    modifier = Modifier.size(iconSize)
                )
            }
            if (iconVector != null) {
                Icon(
                    iconVector, contentDescription = "",
                    tint = colorIcon,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.clickable {
            onClick()
        },
        colors = CardDefaults.cardColors(containerColor = green80)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Done",
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight(500)
            )
        }
    }
}

@Preview
@Composable
private fun ViewIconBox() {
    MediMateTheme {
        Column {
            IconBox(
                onClick = {},
                modifier = Modifier.size(56.dp),
                colorContainer = green80,
                iconVector = Icons.Filled.Add,
                colorIcon = Color.White,
                iconSize = 40.dp
            )
            CustomButton(
                onClick = {},
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(width = 300.dp, height = 50.dp)
            )
        }
    }
}

