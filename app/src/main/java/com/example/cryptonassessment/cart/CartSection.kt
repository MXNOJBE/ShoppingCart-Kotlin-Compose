import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cryptonassessment.cart.BuyButtons
import com.example.cryptonassessment.cart.CartItemList
import com.example.cryptonassessment.cart.TableName
import com.example.cryptonassessment.cart.TotalAmount
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
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TableName()
            HorizontalDivider(
                color = Color.DarkGray,
                thickness = 1.dp
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 46.dp)
                .padding(horizontal = 16.dp)
        ) {
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
                color = MaterialTheme.colorScheme.background,
                thickness = 1.dp
            )
        }

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            TotalAmount(totalAmount)
            BuyButtons()
        }
    }
}
