package com.example.medimate.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.medimate.R
import com.example.medimate.Screen
import com.example.medimate.component.HomeBanner
import com.example.medimate.component.IconBox
import com.example.medimate.component.Itemcard
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.green80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val viewModel: homeViewModel = hiltViewModel()
    LaunchedEffect(key1 = Unit) {
        viewModel.getReminders()
    }

    val status by viewModel.status.observeAsState()
    val reminderList by viewModel.reminderList.observeAsState()

    val selectedItem = remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { selectedItem.value = 0 },
                    icon = {
                        Icon(
                            Icons.Filled.Dashboard, contentDescription = "",
                            tint = if (selectedItem.value == 0) green80 else black80
                        )
                    })
                NavigationBarItem(
                    selected = false,
                    onClick = { selectedItem.value = 1 },
                    icon = {
                        IconBox(
                            onClick = {
                                navController.navigate(Screen.ReminderScreen.route)
                            },
                            modifier = Modifier.size(56.dp),
                            colorContainer = green80,
                            iconVector = Icons.Filled.Add,
                            colorIcon = Color.White,
                            iconSize = 30.dp
                        )
                    })
                NavigationBarItem(
                    selected = false,
                    onClick = { selectedItem.value = 2 },
                    icon = {
                        Icon(
                            Icons.Filled.Checklist, contentDescription = "",
                            tint = if (selectedItem.value == 2) green80 else black80
                        )
                    })
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SearchBar(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = {},
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 28.dp),
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
            LazyColumn(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
                if (reminderList != null) {
                    items(reminderList!!) { reminder ->
                        Itemcard(
                            medicineName = reminder.pillName,
                            reminderTime = reminder.time,
                            status = "Pending"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ViewHomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
//        HomeScreen()
    }
}