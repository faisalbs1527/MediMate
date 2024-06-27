package com.example.medimate.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.R
import com.example.medimate.component.HomeBanner
import com.example.medimate.component.Itemcard
import com.example.medimate.ui.theme.black80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column {
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 12.dp),
            placeholder = {
                Text(text = "Search", fontSize = 16.sp, color = black80)
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }) {

        }
        HomeBanner()
        Text(
            text = "Daily Review",
            modifier = Modifier.padding(horizontal = 32.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight(500)
        )
        LazyColumn {
            items(8) {
                Itemcard()
            }
        }
    }
}

@Preview
@Composable
private fun ViewHomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        HomeScreen()
    }
}