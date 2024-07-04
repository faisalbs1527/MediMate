package com.example.medimate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.R
import com.example.medimate.ui.theme.MediMateTheme
import com.example.medimate.ui.theme.black40
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.gray

@Composable
fun Itemcard(
    modifier: Modifier = Modifier,
    medicineName: String,
    reminderTime: String,
    status: String
) {
    Card(
        colors = CardDefaults.cardColors(gray),
        modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 8.dp, bottom = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.madicine),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(
                    text = medicineName,
                    color = black40,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = reminderTime, color = black80,
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500)
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(2.dp)
                            .background(color = black80, shape = CircleShape)
                    )
                    Text(
                        text = status, color = black80,
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500)
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.next), contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun NameCard(
    modifier: Modifier = Modifier,
    icon: Painter,
    hint: String,
    onValueChange: (String) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }
    Card(
        colors = CardDefaults.cardColors(gray),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = icon,
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            TextField(
                value = name,
                onValueChange = {
                    if (it.length <= 20) {
                        name = it
                        onValueChange(it)
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        text = hint, color = black80,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500)
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun ViewItemCard() {
    MediMateTheme() {
        Column {
            Itemcard(
                medicineName = "",
                reminderTime = "",
                status = ""
            )
            NameCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 28.dp, end = 28.dp, top = 8.dp, bottom = 4.dp),
                icon = painterResource(id = R.drawable.madicine),
                hint = "Ex: Napa Extra",
                onValueChange = {})
        }
    }
}