package com.example.cryptonassessment.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cryptonassessment.R
import com.example.cryptonassessment.products.ProductItem
import com.example.cryptonassessment.formatPrice

@Composable
fun CartItem(
    item: ProductItem,
    addItemCount: (id: Int, count: Int) -> Unit,
    deleteItemCount: (id: Int, count: Int) -> Unit,
    productCount: Int,
    mapCount: Map<Int, Int>,
    addTotalAmount: (Double) -> Unit,
    reduceTotalAmount: (Double) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.padding_large))
                    .size(dimensionResource(id = R.dimen.image_size_medium)),
                model = R.drawable.fooditem2,
                contentDescription = null
            )
            Column {
                val formattedPrice = formatPrice(item.productPrice)
                Text(
                    text = item.productName,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = dimensionResource(id = R.dimen.text_size_small).value.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = formattedPrice,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp
                )
            }
        }
        Surface(
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color(0xffdbe6f7)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                Surface(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.button_height))
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
                    onClick = {
                        deleteItemCount(item.productId, productCount)
                        reduceTotalAmount(item.productPrice)
                    },
                ) {
                    Icon(
                        modifier = Modifier.background(Color(0xffb5c1d2)),
                        imageVector = Icons.Filled.Close,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_large)),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.background,
                    fontSize = dimensionResource(id = R.dimen.text_size_large).value.sp,
                    text = (mapCount[item.productId] ?: 0).toString()
                )
                Surface(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.button_height))
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
                    onClick = {
                        addItemCount(item.productId, productCount)
                        addTotalAmount(item.productPrice)
                    },
                ) {
                    Icon(
                        modifier = Modifier.background(Color(0xffb5c1d2)),
                        imageVector = Icons.Rounded.Add,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
