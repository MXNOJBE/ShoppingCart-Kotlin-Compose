package com.example.cryptonassessment.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ExtraOrderInfo(){
    Column() {
        Text(
            text = "Info: Information about the order",
        )
        Text(
            text = "Toppings : Toppings about the order",
        )
        Text(
            text = "Note: Note about the order ",
        )
    }
}
