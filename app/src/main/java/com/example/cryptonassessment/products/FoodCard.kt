package com.example.cryptonassessment.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cryptonassessment.R
import com.example.cryptonassessment.formatPrice
import com.example.cryptonassessment.ui.theme.selectedGreen

@Composable
fun FoodCard(
    addItemOnce: (item: ProductItem) -> Unit,
    productItem: ProductItem,
    getTotalAmount: (Double) -> Unit,
    addItemCount: (id: Int, count: Int) -> Unit,
    productCount: Int,
    mapsCount: Map<Int, Int>,
) {
    OutlinedCard(
        modifier = Modifier
            .padding(6.dp)
            .wrapContentSize(),
        onClick = {
            addItemCount(productItem.productId, 0)
            addItemOnce(productItem)
            getTotalAmount(productItem.productPrice)
        }) {
        Column(
            Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val formattedPrice = formatPrice(productItem.productPrice)
            Surface(
                shape = RoundedCornerShape(8.dp)
            ) {
                Box(
                    contentAlignment = Alignment.TopEnd
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = R.drawable.fooditem2,
                        contentDescription = null
                    )
                    if (mapsCount[productItem.productId] ?: 0 > 0) {
                        Surface(
                            onClick = {},
                            Modifier
                                .wrapContentSize()
                                .size(24.dp),
                            shape = RoundedCornerShape(48.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .background(selectedGreen),
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                text = (mapsCount[productItem.productId] ?: 0).toString()
                            )
                        }
                    }
                }
            }
            Text(
                fontWeight = FontWeight.Bold,
                text = productItem.productName
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Black,
                    text = formattedPrice
                )
                Text(
                    text = "Discount $",
                )
            }
        }
    }
}