package com.example.cryptonassessment.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TableName(){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Bigger Text",
                fontWeight = FontWeight.W600,
                fontSize = 16.sp

            )
            Text(text = "Text2")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Table")
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "A01",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }
    }
}