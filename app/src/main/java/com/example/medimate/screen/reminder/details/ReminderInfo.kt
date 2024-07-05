package com.example.medimate.screen.reminder.details

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.R
import com.example.medimate.Screen
import com.example.medimate.component.CustomButton
import com.example.medimate.component.IconBox
import com.example.medimate.db.model.reminderEntity
import com.example.medimate.ui.theme.MediMateTheme
import com.example.medimate.ui.theme.black40
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.gray
import com.example.medimate.ui.theme.yellow80

@Composable
fun ReminderInfo() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconBox(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 28.dp, top = 28.dp, bottom = 12.dp)
                    .size(48.dp),
                colorContainer = gray,
                iconVector = Icons.Filled.ArrowBack,
                colorIcon = black80,
                iconSize = 24.dp
            )

            IconBox(
                onClick = {

                },
                modifier = Modifier
                    .padding(end = 28.dp, top = 28.dp, bottom = 12.dp)
                    .size(48.dp),
                colorContainer = gray,
                iconVector = Icons.Filled.EditNote,
                colorIcon = black80,
                iconSize = 24.dp
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.pillimage),
                contentDescription = "",
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = "Medicine Name",
                fontSize = 24.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                text = "(Before Meal)",
                fontSize = 16.sp,
                fontWeight = FontWeight(300),
                color = black40,
                fontStyle = FontStyle.Italic
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 28.dp)
                .background(color = yellow80, shape = RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Amount",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600)
                        )
                        Text(
                            text = "2",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(300),
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Remaining(days)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600)
                        )
                        Text(
                            text = "10",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(300),
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Reminder Time",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    )
                    Text(
                        text = "10:15 PM",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(300),
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CustomButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(horizontal = 28.dp, vertical = 40.dp)
                    .size(width = 260.dp, height = 40.dp),
                text = "Mark As Completed"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowReminderInfo() {
    MediMateTheme {
        ReminderInfo()
    }
}