package com.example.cryptonassessment


import CartSection
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptonassessment.products.ProductCategorySliderRow
import com.example.cryptonassessment.products.ProductGridComponent
import com.example.cryptonassessment.products.ProductItem
import com.example.cryptonassessment.products.chickenProductList
import com.example.cryptonassessment.products.chineseProductList
import com.example.cryptonassessment.products.drinksProductList
import com.example.cryptonassessment.products.seafoodProductList
import com.example.cryptonassessment.products.vegproductsList

@Composable
fun MainProductCard(innerPadding: PaddingValues) {
    var cartItems by remember { mutableStateOf(listOf<ProductItem>()) }

    var productCount by remember { mutableIntStateOf(0) }

    var totalAmount by remember { mutableDoubleStateOf(0.0) }

    var mapsCount by remember { mutableStateOf(mapOf<Int, Int>()) }

    var categoryMap by remember { mutableStateOf(mapOf<String, List<ProductItem>>()) }

    var itemsList by remember { mutableStateOf(vegproductsList) }

    var searchQuery by remember { mutableStateOf("") }

    categoryMap = mapOf(
        "Veg Products" to vegproductsList,
        "Chicken Products" to chickenProductList,
        "Chinese Products" to chineseProductList,
        "Seafood Products" to seafoodProductList,
        "Drinks Products" to drinksProductList
    )

    val removeFromCart: (id: Int) -> Unit = { id ->
        cartItems = cartItems.filter {
            it.productId != id
        }
    }

    val addItemCount: (id: Int, count: Int) -> Unit = { id, _ ->
        mapsCount = mapsCount.toMutableMap().apply {
            val currentCount = this[id] ?: 0
            this[id] = currentCount + 1
        }
    }

    val deleteItemCount: (id: Int, count: Int) -> Unit = { id, _ ->
        mapsCount = mapsCount.toMutableMap().apply {
            val currentCount = this[id] ?: 0
            if (currentCount > 1) {
                this[id] = currentCount - 1
            } else {
                remove(id)
                removeFromCart(id)
            }
        }
    }

    val addItemOnce: (item: ProductItem) -> Unit = { item ->
        cartItems = cartItems.filter {
            it.productId != item.productId
        }
        cartItems = cartItems + item
        productCount = 1
    }

    val addTotalAmount: (price: Double) -> Unit = { price ->
        totalAmount += price
    }

    val reduceTotalAmount: (price: Double) -> Unit = { price ->
        totalAmount = if (totalAmount >= price) totalAmount - price else 0.0
    }

    var returnCategoryItems: (category: String) -> Unit = { category ->
        itemsList = categoryMap[category] ?: vegproductsList
    }

    val filteredItemsList: List<ProductItem> = if (searchQuery.isEmpty()) {
        itemsList
    } else {
        categoryMap.values.flatten().filter {
            it.productPrice.toString().contains(searchQuery, ignoreCase = true) ||
                    it.productName.contains(searchQuery, ignoreCase = true)
        }
    }

    Row {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxHeight()
                .fillMaxWidth(0.6f)
                .padding(innerPadding)
        ) {
            ProductCategorySliderRow(returnCategoryItems)
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            )
            HorizontalDivider()
            ProductGridComponent(
                cartItems,
                addItemOnce,
                productCount,
                addTotalAmount,
                totalAmount,
                addItemCount,
                filteredItemsList,
                mapsCount)
        }
        VerticalDivider(
            color = Color.DarkGray,
            thickness = dimensionResource(id = R.dimen.horizontal_divider_thickness)
        )
        Column(
            modifier = Modifier.padding(
                vertical = dimensionResource(id = R.dimen.padding_large),
                horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            CartSection(
                cartItems,
                addItemCount,
                deleteItemCount,
                productCount,
                mapsCount,
                addTotalAmount,
                totalAmount,
                reduceTotalAmount
            )
        }
    }
}

fun formatPrice(price: Double): String {
    return if (price % 1.0 == 0.0) {
        String.format("%.0f$", price)
    } else {
        String.format("%.2f$", price)
    }
}

@Composable
@Preview(showBackground = true)
fun SubProductComponentPreview() {
    MainProductCard(PaddingValues(12.dp))
}
