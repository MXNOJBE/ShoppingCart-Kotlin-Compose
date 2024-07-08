package com.example.cryptonassessment.products

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ProductGridComponent(
    cartItems: List<ProductItem>,
    addItemOnce: (item: ProductItem) -> Unit,
    productCount: Int,
    getTotalAmount: (Double) -> Unit,
    totalAmount: Double,
    addItemCount: (id: Int, count: Int) -> Unit,
    itemsList: List<ProductItem>,
    mapsCount: Map<Int, Int>,
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Fixed(4)
    ) {
        items(itemsList.size) { item ->
            val productItem = itemsList[item]
            FoodCard(
                addItemOnce,
                productItem,
                getTotalAmount,
                addItemCount,
                productCount,
                mapsCount
            )
        }
    }
}