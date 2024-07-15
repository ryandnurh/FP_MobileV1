package com.example.nawasena_company.registeredYes

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.registeredNo.BottomBar2
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toMainRegistered
import com.example.nawasena_company.scrapFun.toPaymentMethod

@Composable
fun Payment3(
    navController: NavController,
    title: String,
    image: String,
    star : String,
    rating : String,
    amount: String,
    tourPrice: String
){
    val tourName = title.toIntOrNull()
    val tourImage = image.toIntOrNull()
    val tourStar = star.toIntOrNull()
    val tourRating = rating.toIntOrNull()
    val tourAmount = amount.toIntOrNull()

    Scaffold (
        topBar = {
            TopBarCustom(
                navController = navController,
                title = stringResource(R.string.pembayaran_text),
                route = "$toPaymentMethod/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice"
            )
        },
        bottomBar = {
            BottomBar2(
                navController = navController,
                nextLabel = stringResource(R.string.go_to_main_menu),
                navigate = true,
                route = toMainRegistered
            )
        }
    ) {
        LazyColumn(contentPadding = it ){
            item {
                Text(
                    text = stringResource(R.string.waiting_for_payment),
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
            item {
                PaymentTotalCard(tourPrice)
                AccountVirtual()
                Petunjuk()
            }
        }
    }
}

@Composable
fun PaymentTotalCard(tourPrice: String){
    Card (
        colors =
            if (isSystemInDarkTheme()){
                CardDefaults.cardColors(Color(0xFF436A43))
            }else{
                CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondaryContainer)
            },
        modifier = Modifier
            .padding(10.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(400.dp)
            .height(123.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {

        PriceSet(tourPrice = tourPrice)
        Divider(thickness = 2.dp, color = Color.Black)
        CountDown()
    }
}

@Composable
fun AccountVirtual(){
    val localClipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    val pressed = true


    Card (
        colors =
            if (isSystemInDarkTheme()){
                CardDefaults.cardColors(Color(0xFF436A43))
            }else{
                CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondaryContainer)
            }
        ,
        modifier = Modifier
            .padding(10.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(400.dp)
            .height(123.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.onSecondary)
    ){
        Text(
            text = stringResource(id = R.string.bank_bca),
            color = MaterialTheme.colorScheme.onSecondary,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(12.dp)
        )
        Divider(thickness = 2.dp, color = Color.Black)
        Text(
            text = stringResource(R.string.no_rekening_virtual_account),
            color = MaterialTheme.colorScheme.onSecondary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )
        Row{
            Text(
                text = stringResource(R.string.no_virtual_acc),
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            )
            Text(
                text = stringResource(R.string.salin),
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .clickable {
                        if (pressed) {
                            Toast
                                .makeText(context, "salin berhasil", Toast.LENGTH_SHORT)
                                .show()
                            localClipboardManager.setText(AnnotatedString("126 0895 4026 55123"))
                        } else {
                            println("a")
                        }
                    }
            )
        }
    }
}

@Composable
fun Petunjuk(){
    Image(
        painter = painterResource(
            id =
            if (isSystemInDarkTheme()){
                R.drawable.petunjuk
            }else{
                R.drawable.petunjuk_light
            }
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(476.dp)
            .height(308.dp)
            .padding(10.dp)
    )
}


@Composable
fun PriceSet(tourPrice: String){
    Box {
        Row (
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.padding(12.dp)
        ){
            Text(
                text = "Total Pembayaran",
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.rp),
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.padding(end = 20.dp))
            Text(
                text = tourPrice,
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}

@Composable
fun CountDown() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier.padding(top = 10.dp )
        ) {
            Text(
                text = "Bayar Dalam",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondary,
                ),
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "23 jam 59 menit 41 detik",
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSecondary,
                ),
                modifier = Modifier.padding(end = 12.dp)
            )
        }
        Text(
            text = "Jatuh tempo 1 may 2024, 11:41",
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondary,
            ),
            modifier = Modifier.padding(start = 12.dp)
        )
    }

}
