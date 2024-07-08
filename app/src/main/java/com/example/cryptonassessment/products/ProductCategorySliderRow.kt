package com.example.cryptonassessment.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptonassessment.R
import com.example.cryptonassessment.ui.theme.selectedGreen

@Composable
fun ProductCategorySliderRow(
    returnCategoryItems: (category: String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(end = 12.dp)
            .padding(vertical = 12.dp)
            .height(40.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(),
            shape = RectangleShape,
            onClick = { /*TODO*/ },
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }
        LazyRow(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(productsListNames.size) { i->
                val foodCategory = productsListNames[i]
                ProductSelectionItem(foodCategory, returnCategoryItems)
            }
        }
        Surface(
            modifier = Modifier.fillMaxHeight(),
            shape = RectangleShape,
            onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
        Surface(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxHeight(),
            shape = CircleShape,
            onClick = { /*TODO*/ },
        ) {
            Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
        }
    }
}

@Composable
fun ProductSelectionItem(foodCategory: String, returnCategoryItems: (category: String) -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.background,
            containerColor = selectedGreen,
            disabledContentColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = selectedGreen
        ),
        contentPadding = PaddingValues(horizontal = 28.dp),
        shape = ButtonDefaults.shape,
        onClick = {
            returnCategoryItems(foodCategory)
        },
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ) {
        Text(
            text = foodCategory ,
            color = Color.White,
            fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp
        )
    }
}