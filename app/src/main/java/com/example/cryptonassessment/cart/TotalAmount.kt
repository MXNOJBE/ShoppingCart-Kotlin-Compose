package com.example.cryptonassessment.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TotalAmount(totalAmount: Double) {
    Surface(
        modifier = Modifier
            .padding(12.dp),
        color = Color(0xfff1f4f9),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "$${String.format("%.2f", totalAmount)}",
                fontWeight = FontWeight.Black,
                fontSize = 32.sp
            )
        }
    }
}
