package com.example.nawasena_company.registeredYes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.registeredNo.BottomBar2
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toDetailsRegistered
import com.example.nawasena_company.scrapFun.toPaymentMethod

@Composable
fun PaymentDetails (
    title : String,
    image : String,
    star : String,
    rating : String,
    amount: String,
    tourPrice: String,
    navController: NavController
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
                title = stringResource(R.string.paymentDetails),
                route = "$toDetailsRegistered/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice"
            )
        },
        bottomBar = {
            BottomBar2(
                navController = navController,
                nextLabel = stringResource(R.string.proceedPayment),
                navigate = true,
                route = "$toPaymentMethod/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice"
            )
        }
    ) {ip ->
        LazyColumn(contentPadding = ip, modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom ){
            item  {
                PaymentDetailsLayout(
                    tourName!!,
                    tourImage!!,
                    tourStar!!,
                    tourRating!!,
                    tourAmount!!,
                    tourPrice
                )
            }
        }
    }
}

@Composable
fun PaymentDetailsLayout(
    tourName : Int,
    tourImage : Int,
    tourStar : Int,
    tourRating : Int,
    tourAmount : Int,
    tourPrice : String
){
    DetailsCard(
        title = tourName,
        star = tourStar,
        rating = tourRating,
        amount = tourAmount,
        image = tourImage
    )
    DetailsUser(
        price = tourPrice
    )

}



@Composable
fun DetailsCard(
    title : Int,
    star: Int,
    rating : Int,
    amount : Int,
    image : Int
){
    Card (
        modifier = Modifier
            .padding(8.dp)
            .height(250.dp)
            .padding(10.dp)

    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.White
                )
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .alpha(0.6f)
                    .clip(RoundedCornerShape(10.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.gradient_box),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .alpha(0.6f)
                    .clip(RoundedCornerShape(10.dp))
            )
            Details( title, image,star,rating,amount )
        }
    }
}

@Composable
fun Details(
    @StringRes title : Int,
    @DrawableRes image : Int,
    @DrawableRes star : Int,
    @StringRes rating : Int,
    @StringRes amount : Int
){
    Column {
        Row {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(151.dp)
                    .height(125.dp)
                    .padding(20.dp, 20.dp)
                    .clip(RoundedCornerShape(13.dp))
            )
            Column {
                Text(
                    text = stringResource(title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding( top = 13.dp)
                )
                Row {
                    Image(painter = painterResource(star),
                        contentDescription = null,
                        modifier = Modifier.offset(y = 3.dp, x = (-4).dp)
                    )
                    Spacer(modifier = Modifier.padding(end = 35.dp))
                    Text(
                        text = stringResource(rating),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.padding(end = 7.dp))
                    Text(
                        text = stringResource(amount),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.desc_detail),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, bottom = 10.dp)
        )
    }
}

@Composable
fun DetailsUser(price: String){

    Column (modifier = Modifier.fillMaxSize()){
        Card (
            colors =
            if (isSystemInDarkTheme()){
                CardDefaults.cardColors(MaterialTheme.colorScheme.background)
            }else{
                CardDefaults.cardColors(Color(0xFFEEF0E5))
            }
            ,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))

        ){
            Text(
                text = stringResource(id = R.string.id_pemesan),
                color =
                if (isSystemInDarkTheme()){
                    MaterialTheme.colorScheme.onSecondary
                }else{
                     Color.Black
                }
                ,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 30.dp, top = 28.dp)
            )
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(15.dp)),
                colors = CardDefaults.cardColors(Color(0xFFD9D9D9))
            ) {
                LayoutUser(icon = Icons.Default.Person, userID = stringResource(id = R.string.profileValue1))
                LayoutUser(icon = Icons.Default.Call, userID = stringResource(id = R.string.profileTitle3))
            }

            Text(
                text = stringResource(id = R.string.id_jumlah_personil),
                color =
                if (isSystemInDarkTheme()){
                    MaterialTheme.colorScheme.onSecondary
                }else{
                    Color.Black
                }
                ,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 30.dp, top = 10.dp)
            )
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clip(RoundedCornerShape(15.dp)),
                colors = CardDefaults.cardColors(Color(0xFFD9D9D9))
            ) {
                LayoutUser2(image = painterResource(R.drawable.family), userID = stringResource(id = R.string.user_ID_3))

            }
            Spacer(modifier = Modifier.height(16.dp))

        }
        PriceCard(tourPrice = price)

    }


}

@Composable
fun LayoutUser2(image: Painter, userID: String){
    val color =
        if (isSystemInDarkTheme()){
            Color(0xFF304D30)
        }else{
            MaterialTheme.colorScheme.onSecondary
        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = 10.dp, top = 10.dp, start = 10.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.padding(end = 20.dp))

        Text(
            text = userID,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = color
        )
    }
}

@Composable
fun LayoutUser(icon: ImageVector, userID: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = 5.dp, top = 5.dp, start = 10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.padding(end = 20.dp))

        Text(
            text = userID,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color =
            if (isSystemInDarkTheme()){
                MaterialTheme.colorScheme.background
            }else{
                MaterialTheme.colorScheme.onSecondary
            }

        )

    }
}

@Composable
fun PriceCard(tourPrice: String){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(0.dp))
            .background(
                if (isSystemInDarkTheme()) {
                    MaterialTheme.colorScheme.background
                } else {
                    MaterialTheme.colorScheme.onErrorContainer
                }

            )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.padding(12.dp)
            ){
            Text(
                text = "Total",
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.rupiah),
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.padding(end = 20.dp))
            Text(
                text = tourPrice,
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }

    }
}



