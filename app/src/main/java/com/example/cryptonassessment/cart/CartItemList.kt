package com.example.cryptonassessment.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.cryptonassessment.R
import com.example.cryptonassessment.products.ProductItem

@Composable
fun CartItemList(
    cartItems: List<ProductItem>,
    addItemCount: (id: Int, count: Int) -> Unit,
    deleteItemCount: (id: Int, count: Int) -> Unit,
    productCount: Int,
    mapCount: Map<Int, Int>,
    getTotalAmount: (Double) -> Unit,
    reduceTotalAmount: (price: Double) -> Unit
) {
    Column {
        LazyColumn(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxHeight(0.7f)
        ) {
            items(cartItems.size) { item ->
                val individualItem = cartItems[item]
                CartItem(
                    individualItem,
                    addItemCount,
                    deleteItemCount,
                    productCount,
                    mapCount,
                    getTotalAmount,
                    reduceTotalAmount
                )
            }
        }
        ExtraOrderInfo()
    }
}
