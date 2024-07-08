package com.example.cryptonassessment.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cryptonassessment.products.ProductItem


@Composable
fun CartSection(
    cartItems: List<ProductItem>,
    addItemCount: (id: Int, count: Int) -> Unit,
    deleteItemCount: (id: Int, count: Int) -> Unit,
    productCount: Int,
    mapCount: Map<Int, Int>,
    getTotalAmount: (Double) -> Unit,
    totalAmount: Double,
    reduceTotalAmount: (price: Double) -> Unit
) {

    Column {
        TableName()
        HorizontalDivider(
            color = Color.DarkGray,
            thickness = 1.dp
        )
        CartItemList(
            cartItems,
            addItemCount,
            deleteItemCount,
            productCount,
            mapCount,
            getTotalAmount,
            reduceTotalAmount
        )
        HorizontalDivider(
            color = Color.DarkGray,
            thickness = 1.dp
        )
        Spacer(modifier = Modifier.height(12.dp))
        TotalAmount(totalAmount)
        BuyButtons()
    }
}
