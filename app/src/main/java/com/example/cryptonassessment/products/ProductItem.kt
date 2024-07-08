package com.example.cryptonassessment.products

data class ProductItem(
    val productId: Int,
    val productName: String,
    val productPrice: Double,
)

val vegproductsList: List<ProductItem> = (1..24).map { i ->
    ProductItem(
        productId = i,
        productName = "Veg Item $i",
        productPrice = i.toDouble(),
    )
}

val chickenProductList: List<ProductItem> = (1..24).map { i->
    ProductItem(
        productId = i,
        productName = "Chicken Item $i",
        productPrice = i.toDouble(),
    )
}

val chineseProductList: List<ProductItem> = (1..24).map { i->
    ProductItem(
        productId = i,
        productName = "Chinese Item $i",
        productPrice = i.toDouble(),
    )
}

val seafoodProductList: List<ProductItem> = (1..24).map { i->
    ProductItem(
        productId = i,
        productName = "Seafood Item $i",
        productPrice = i.toDouble(),
    )
}

val drinksProductList: List<ProductItem> = (1..24).map { i->
    ProductItem(
        productId = i,
        productName = "Drink Item $i",
        productPrice = i.toDouble(),
    )
}

val productsListNames = listOf("Veg Products", "Chicken Products", "Chinese Products", "Seafood Products", "Drinks Products")

