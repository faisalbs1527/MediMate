package com.example.medimate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.R
import com.example.medimate.ui.theme.black40
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.red80
import com.example.medimate.ui.theme.yellow80

@Composable
fun HomeBanner(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Text(
                text = "Hello,",
                modifier = Modifier.padding(start = 32.dp, top = 8.dp),
                fontSize = 28.sp,
                fontWeight = FontWeight(600),
                color = black40
            )
            Text(
                text = "Faisal",
                modifier = Modifier.padding(start = 32.dp),
                fontSize = 28.sp,
                fontWeight = FontWeight(400),
                color = black40
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 96.dp, bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = yellow80)
        ) {
            Column {
                Text(
                    text = "Your plan",
                    modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = black40
                )
                Text(
                    text = "for today",
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = black40
                )
                Text(
                    text = "1 of 4 completed",
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp),
                    fontSize = 12.sp,
                    color = black80
                )
                Text(
                    text = "Show More",
                    modifier = Modifier.padding(start = 20.dp, top = 32.dp, bottom = 16.dp),
                    fontSize = 14.sp,
                    color = red80,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.bannerphoto),
                contentDescription = "",
                modifier = Modifier.size(230.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ViewHomeBanner() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        HomeBanner()
    }
}