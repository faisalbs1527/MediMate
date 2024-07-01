package com.example.medimate.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.medimate.ui.theme.black80
import com.example.medimate.ui.theme.gray


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownCustom(
    modifier: Modifier,
    icon: Painter,
    optionList: List<String>,
    onValueChange: (String) -> Unit,
    onTypeChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(optionList[0]) }
    val dropDownIcon = remember(expanded) {
        if (expanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown
    }
    var value by remember {
        mutableStateOf("")
    }
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(gray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon, contentDescription = "",
                modifier = Modifier
                    .weight(.2f)
                    .size(20.dp),
                tint = black80
            )

            BasicTextField(
                modifier = Modifier
                    .weight(.15f)
                    .padding(start = 4.dp),
                value = value,
                onValueChange = {
                    if (it.length <= 2) {
                        value = it
                        onValueChange(it)
                    }
                },
                decorationBox = { innerTextField ->
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = "0", color = black80,
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500)
                            )
                        }
                        innerTextField()
                    }
                }
            )
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.weight(.7f)
            ) {

                TextField(
                    modifier = Modifier.menuAnchor(),
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = {},
                    trailingIcon = {
                        Icon(
                            dropDownIcon, "",
                            modifier = Modifier.size(26.dp)
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    optionList.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption) },
                            onClick = {
                                selectedOptionText = selectionOption
                                onTypeChange(selectionOption)
                                expanded = false
                            },
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Column {
            val options1 = listOf("pills", "ml", "tbsp")
            val options2 = listOf("days", "month", "year")
            Row(modifier = Modifier.padding(horizontal = 28.dp)) {
                DropDownCustom(modifier = Modifier.weight(.5f),
                    icon = painterResource(id = R.drawable.pill),
                    optionList = options1,
                    onValueChange = {},
                    onTypeChange = {})
                Spacer(modifier = Modifier.size(8.dp))
                DropDownCustom(modifier = Modifier.weight(.5f),
                    icon = painterResource(id = R.drawable.days),
                    optionList = options2,
                    onValueChange = {},
                    onTypeChange = {})
            }
        }
    }

}
