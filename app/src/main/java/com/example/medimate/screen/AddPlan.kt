package com.example.medimate.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medimate.component.IconBox
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.gray

@Composable
fun AddMedicine(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        IconBox(
            modifier = Modifier
                .padding(start = 28.dp, top = 28.dp, bottom = 12.dp)
                .size(48.dp),
            colorContainer = gray,
            icon = Icons.Filled.ArrowBack,
            colorIcon = black80,
            iconSize = 24.dp
        )
    }
}

@Preview
@Composable
private fun ViewAddMedicine() {
    Surface(modifier = Modifier.fillMaxSize()) {
        AddMedicine()
    }
}