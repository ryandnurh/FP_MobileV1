package com.example.nawasena_company.registeredYes


import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.registeredNo.BottomBar2
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toPayment1
import com.example.nawasena_company.scrapFun.toPayment3

@Composable
fun PaymentMethod(
    title : String,
    image : String,
    star : String,
    rating : String,
    amount: String,
    price: String,
    navController: NavController
){
    val tourName = title.toIntOrNull()
    val tourImage = image.toIntOrNull()
    val tourStar = star.toIntOrNull()
    val tourRating = rating.toIntOrNull()
    val tourAmount = amount.toIntOrNull()

    PaymentMethodLayout(
        tourName = tourName!!,
        tourImage = tourImage!!,
        tourStar = tourStar!!,
        tourRating = tourRating!!,
        tourAmount = tourAmount!!,
        tourPrice = price,
        navController = navController
    )
}

@Composable
fun PaymentMethodLayout(
    tourName : Int,
    tourImage : Int,
    tourStar : Int,
    tourRating : Int,
    tourAmount: Int,
    tourPrice: String,
    navController: NavController
){

    Scaffold (
        topBar = {
            TopBarCustom(
                navController = navController,
                title = stringResource(R.string.payment_method),
                route = "$toPayment1/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice"
            )
        },
        bottomBar = {
            BottomBar2(
                navController = navController,
                nextLabel = stringResource(R.string.konfirmasi),
                navigate = true,
                route = "$toPayment3/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice"
            )
        }
    ){ip ->
        LazyColumn(contentPadding = ip, modifier = Modifier.fillMaxSize()){
            item {
                Text(
                    text = stringResource(R.string.choice),
                    color =
                        if (isSystemInDarkTheme()){
                            Color(0xFFC5D7C5)
                        }else{
                            MaterialTheme.colorScheme.inversePrimary
                         },
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 12.dp)
                )
                PaymentMethodLayout()

                Spacer(modifier = Modifier.height(150.dp))


            }
        }
    }
}


@Composable
fun PaymentMethodLayout(){
    var checkedBank by remember { mutableStateOf(false) }
    var checkedStore by remember { mutableStateOf(false) }
    var checkedWallet by remember { mutableStateOf(false) }

    var checkedBank1 by remember { mutableStateOf(false) }
    var checkedBank2 by remember { mutableStateOf(false) }
    var checkedBank3 by remember { mutableStateOf(false) }

    var checkedStore1 by remember { mutableStateOf(false) }
    var checkedStore2 by remember { mutableStateOf(false) }

    var checkedWallet1 by remember { mutableStateOf(false) }
    var checkedWallet2 by remember { mutableStateOf(false) }
    var checkedWallet3 by remember { mutableStateOf(false) }

    val arrow1: ImageVector =
        if (checkedBank){
            Icons.Default.KeyboardArrowUp
        }else{
            Icons.Default.KeyboardArrowDown
        }

    val arrow2: ImageVector =
        if (checkedStore){
            Icons.Default.KeyboardArrowUp
        }else{
            Icons.Default.KeyboardArrowDown
        }

    val arrow3: ImageVector =
        if (checkedWallet){
            Icons.Default.KeyboardArrowUp
        }else{
            Icons.Default.KeyboardArrowDown
        }



    Column{

        Spacer(modifier = Modifier.height(20.dp))

        PaymentType(
            paymentTitle = "Transfer Bank",
            onClick = { checkedBank = !checkedBank },
            arrow = arrow1
        )

        if (checkedBank){
            PaymentSubMethod(
                subTitle = "Bank BCA",
                checked = checkedBank1,
                onCheckedChange = {
                    checkedBank1 = true
                    checkedBank2 = false
                    checkedBank3 = false
                    checkedStore1 = false
                    checkedStore2 = false
                    checkedWallet1 = false
                    checkedWallet2 = false
                    checkedWallet3 = false
                }
            )
            PaymentSubMethod(
                subTitle = "Bank BRI",
                checked = checkedBank2,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = true
                    checkedBank3 = false
                    checkedStore1 = false
                    checkedStore2 = false
                    checkedWallet1 = false
                    checkedWallet2 = false
                    checkedWallet3 = false
                }
            )
            PaymentSubMethod(
                subTitle = "Bank BNI",
                checked = checkedBank3,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = false
                    checkedBank3 = true
                    checkedStore1 = false
                    checkedStore2 = false
                    checkedWallet1 = false
                    checkedWallet2 = false
                    checkedWallet3 = false
                }
            )
        }

        PaymentType(
            paymentTitle = "Bayar di Mitra",
            onClick = { checkedStore = !checkedStore },
            arrow = arrow2
        )


        if (checkedStore){
            PaymentSubMethod(
                subTitle = "Indomaret",
                checked = checkedStore1,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = false
                    checkedBank3 = false
                    checkedStore1 = true
                    checkedStore2 = false
                    checkedWallet1 = false
                    checkedWallet2 = false
                    checkedWallet3 = false
                }
            )
            PaymentSubMethod(
                subTitle = "Alfamart",
                checked = checkedStore2,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = false
                    checkedBank3 = false
                    checkedStore1 = false
                    checkedStore2 = true
                    checkedWallet1 = false
                    checkedWallet2 = false
                    checkedWallet3 = false
                }
            )
        }


        PaymentType(
            paymentTitle = "E-Wallet",
            onClick = { checkedWallet = !checkedWallet },
            arrow = arrow3
        )


        if (checkedWallet){
            PaymentSubMethod(
                subTitle = "OVO",
                checked = checkedWallet1,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = false
                    checkedBank3 = false
                    checkedStore1 = false
                    checkedStore2 = false
                    checkedWallet1 = true
                    checkedWallet2 = false
                    checkedWallet3 = false
                }
            )
            PaymentSubMethod(
                subTitle = "DANA",
                checked = checkedWallet2,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = false
                    checkedBank3 = false
                    checkedStore1 = false
                    checkedStore2 = false
                    checkedWallet1 = false
                    checkedWallet2 = true
                    checkedWallet3 = false
                }
            )
            PaymentSubMethod(
                subTitle = "Go-Pay",
                checked = checkedWallet3,
                onCheckedChange = {
                    checkedBank1 = false
                    checkedBank2 = false
                    checkedBank3 = false
                    checkedStore1 = false
                    checkedStore2 = false
                    checkedWallet1 = false
                    checkedWallet2 = false
                    checkedWallet3 = true
                }
            )
        }
    }
}

@Composable
fun PaymentType(
    paymentTitle: String,
    arrow: ImageVector,
    onClick: () -> Unit,

){

    Card (
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, bottom = 8.dp),
        colors =
            if (isSystemInDarkTheme()){
                CardDefaults.cardColors(Color(0xFF436A43))
            }else{
                CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondaryContainer)
            }

    ){

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = paymentTitle,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = arrow,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.clickable { onClick() }
            )

        }
    }
}



@Composable
fun PaymentSubMethod(
    subTitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ){
        Card (
            colors = CardDefaults.cardColors(Color(0xFF8FB76E)),
            modifier = Modifier
                .padding(start = 100.dp, end = 12.dp, bottom = 8.dp)
                .fillMaxWidth(),
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp)
            ){
                Text(
                    text = subTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color =
                    if (isSystemInDarkTheme()){
                        Color(0xFFFFFFFF)
                    }else{
                        MaterialTheme.colorScheme.background
                    },
                )
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(
                    checked = checked,
                    onCheckedChange = onCheckedChange,
                )
            }
        }
    }
}