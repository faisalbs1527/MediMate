package com.example.medimate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.R
import com.example.medimate.ui.theme.MediMateTheme
import com.example.medimate.ui.theme.black40
import com.example.medimate.ui.theme.black80

@Composable
fun Itemcard(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(Color(0xFFF7F5F5)),
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
                    text = "MedicineName",
                    color = black40,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "10:00 AM", color = black80,
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
                        text = "Completed", color = black80,
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

@Preview
@Composable
private fun ViewItemCard() {
    MediMateTheme() {
        Itemcard()
    }
}