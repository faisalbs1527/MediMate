package com.example.medimate.screen

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medimate.R
import com.example.medimate.component.CustomButton
import com.example.medimate.component.DropDownCustom
import com.example.medimate.component.IconBox
import com.example.medimate.component.NameCard
import com.example.medimate.ui.theme.black40
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.gray
import com.example.medimate.ui.theme.green40
import com.example.medimate.ui.theme.green80
import java.util.Calendar

@Composable
fun AddMedicine(modifier: Modifier = Modifier) {

    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    var Time by remember {
        mutableStateOf("")
    }

    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            Time = "$mHour:$mMinute"
        }, mHour, mMinute, false
    )

    val selectedItem = remember {
        mutableStateOf(0)
    }
    var Name by remember {
        mutableStateOf("")
    }

    var amount by remember {
        mutableStateOf("")
    }

    var amountType by remember {
        mutableStateOf("")
    }

    var howLong by remember {
        mutableStateOf("")
    }
    var howLongType by remember {
        mutableStateOf("")
    }

    val options1 = listOf("pills", "ml", "tbsp")
    val options2 = listOf("days", "month", "year")

    Column(modifier = Modifier.fillMaxSize()) {
        IconBox(
            onClick = {},
            modifier = Modifier
                .padding(start = 28.dp, top = 28.dp, bottom = 12.dp)
                .size(48.dp),
            colorContainer = gray,
            iconVector = Icons.Filled.ArrowBack,
            colorIcon = black80,
            iconSize = 24.dp
        )

        Text(
            text = "Add Plan",
            modifier = Modifier.padding(start = 28.dp, top = 10.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight(600),
            color = black40
        )
        Text(
            text = "Pills name",
            modifier = Modifier.padding(start = 28.dp, top = 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            color = black40
        )
        NameCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 8.dp, bottom = 4.dp),
            icon = painterResource(id = R.drawable.madicine),
            hint = "Ex: Napa Extra",
            onValueChange = { Name = it }
        )
        Text(
            text = "Amount & How long?",
            modifier = Modifier.padding(start = 28.dp, top = 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            color = black40
        )
        Row(Modifier.padding(horizontal = 28.dp, vertical = 10.dp)) {

            //amount
            DropDownCustom(modifier = Modifier.weight(.5f),
                icon = painterResource(id = R.drawable.pill),
                optionList = options1,
                onValueChange = {
                    amount = it
                },
                onTypeChange = {
                    amountType = it
                })
            Spacer(modifier = Modifier.size(8.dp))
            //days
            DropDownCustom(modifier = Modifier.weight(.5f),
                icon = painterResource(id = R.drawable.days),
                optionList = options2,
                onValueChange = {
                    howLong = it
                },
                onTypeChange = {
                    howLongType = it
                })
        }
        Text(
            text = "Food & Pills",
            modifier = Modifier.padding(start = 28.dp, top = 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            color = black40
        )
        Row(modifier = Modifier.padding(horizontal = 28.dp, vertical = 10.dp)) {
            IconBox(
                onClick = {
                    selectedItem.value = 1
                },
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(90.dp)
                    .weight(1f),
                colorContainer = if (selectedItem.value == 1) green80 else gray,
                iconPainter = painterResource(id = R.drawable.before),
                colorIcon = if (selectedItem.value == 1) Color.White else black80,
                iconSize = 50.dp
            )
            IconBox(
                onClick = {
                    selectedItem.value = 2
                },
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .size(90.dp)
                    .weight(1f),
                colorContainer = if (selectedItem.value == 2) green80 else gray,
                iconPainter = painterResource(id = R.drawable.inbetween),
                colorIcon = if (selectedItem.value == 2) Color.White else black80,
                iconSize = 50.dp
            )
            IconBox(
                onClick = {
                    selectedItem.value = 3
                },
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(90.dp)
                    .weight(1f),
                colorContainer = if (selectedItem.value == 3) green80 else gray,
                iconPainter = painterResource(id = R.drawable.after),
                colorIcon = if (selectedItem.value == 3) Color.White else black80,
                iconSize = 50.dp
            )
        }
        Text(
            text = "Notification",
            modifier = Modifier.padding(start = 28.dp, top = 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            color = black40
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 12.dp, bottom = 12.dp)
        ) {
            NameCard(
                modifier = Modifier
                    .weight(.7f)
                    .padding(end = 8.dp),
                icon = painterResource(id = R.drawable.notification),
                hint = Time
            ) {
                Time = it
            }
            IconBox(
                onClick = {mTimePickerDialog.show()},
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(.2f)
                    .size(56.dp),
                colorContainer = green40,
                iconVector = Icons.Filled.Add,
                colorIcon = green80,
                iconSize = 40.dp
            )
        }
        CustomButton(
            onClick = {},
            modifier = Modifier
                .padding(start = 28.dp, end = 28.dp, top = 116.dp)
                .size(width = 340.dp, height = 56.dp),
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