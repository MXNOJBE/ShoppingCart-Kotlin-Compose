package com.example.cryptonassessment.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptonassessment.ui.theme.leftButtonColor
import com.example.cryptonassessment.ui.theme.rightButtonColor

@Composable
fun BuyButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier

            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Button(
            contentPadding = PaddingValues(horizontal = 28.dp),
            colors = ButtonColors(
                containerColor = leftButtonColor,
                contentColor = MaterialTheme.colorScheme.background,
                disabledContentColor = leftButtonColor,
                disabledContainerColor = MaterialTheme.colorScheme.background),
            onClick = {},
            modifier = Modifier
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = "Button"
            )
        }
        Button(
            contentPadding = PaddingValues(horizontal = 88.dp),
            shape = RoundedCornerShape(48.dp),
            onClick = {},
            colors = ButtonColors(
                containerColor = rightButtonColor,
                contentColor = MaterialTheme.colorScheme.background,
                disabledContentColor = rightButtonColor,
                disabledContainerColor = MaterialTheme.colorScheme.background),
            modifier = Modifier
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = "Bigger Button"
            )
        }
    }
}