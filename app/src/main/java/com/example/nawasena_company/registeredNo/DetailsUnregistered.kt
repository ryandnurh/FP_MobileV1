package com.example.nawasena_company.registeredNo


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.toLogin
import com.example.nawasena_company.scrapFun.toResultUnregistered





@Composable
fun DetailsUnregistered(
    navController: NavController,
    title: String,
    image: String,
    star : String,
    rating : String,
    amount: String,
    price: String
){
    val tourName = title.toIntOrNull()
    val tourImage = image.toIntOrNull()
    val tourStar = star.toIntOrNull()
    val tourRating = rating.toIntOrNull()
    val tourAmount = amount.toIntOrNull()


    DetailsNoRegister(
        navController = navController,
        title = tourName!!,
        image = tourImage!!,
        star = tourStar!!,
        rating = tourRating!!,
        amount = tourAmount!!,
        price = price
    )
}

@Composable
fun DetailsNoRegister(
    navController: NavController,
    title : Int,
    image : Int,
    star : Int,
    rating : Int,
    amount : Int,
    price : String
){


    Scaffold (
        bottomBar = {
            BottomBar2(
                navController = navController,
                nextLabel = stringResource(R.string.orderNow),
                navigate = false,
                route = toLogin
            )
        }
    ){ip ->
        Column {
            DetailsImage(
                navController = navController,
                tourImage = image,
                tourStar = star,
                tourRating = rating,
                tourAmount = amount,
                tourPrice = price,
                route = toResultUnregistered
            )
            if (isSystemInDarkTheme()){
                Divider(
                    thickness = 10.dp,
                    color = Color(0xFF304D30),
                )
            }else{
                Divider(
                    thickness = 10.dp,
                    color = MaterialTheme.colorScheme.primaryContainer,
                )
            }

            LazyColumn(contentPadding = ip){
                item {
                    DetailsLayout(title)
                }
            }
        }
    }
}

@Composable
fun DetailsLayout(tourName : Int){
    var allButton1 by remember { mutableStateOf(false) }
    var allButton2 by remember { mutableStateOf(false) }
    var allButton3 by remember { mutableStateOf(false) }

    val colorFocused =
        if (isSystemInDarkTheme()){
            Color(0xFF365B36)
        }else{
            MaterialTheme.colorScheme.onTertiary
        }

    val colorUnfocused =
        if (isSystemInDarkTheme()){
            Color(0xFFC5D7C5)
        }else{
            MaterialTheme.colorScheme.tertiaryContainer
        }
        MaterialTheme.colorScheme.onPrimaryContainer

    var colorA by remember { mutableStateOf(colorFocused) }
    var colorB by remember { mutableStateOf(colorUnfocused) }
    var colorC by remember { mutableStateOf(colorUnfocused) }

    var colorTextA by remember { mutableStateOf(colorUnfocused) }
    var colorTextB by remember { mutableStateOf(colorFocused) }
    var colorTextC by remember { mutableStateOf(colorFocused) }


    Column (verticalArrangement = Arrangement.Top) {

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(id = tourName),
            fontSize = 30.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp),
            color = MaterialTheme.colorScheme.inverseOnSurface

        )
        Row {
            Spacer(modifier = Modifier.padding(9.dp))

            AllButton(
                allColor = colorA,
                allText = stringResource(R.string.detailedOptions1),
                colorText = colorTextA,
                onButtonClick = {
                    allButton1 = true
                    allButton2 = false
                    allButton3 = false
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            AllButton(
                allColor = colorB,
                allText = stringResource(R.string.detailedOptions2),
                colorText = colorTextB,
                onButtonClick = {
                    allButton1 = false
                    allButton2 = true
                    allButton3 = false
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            AllButton(
                allColor = colorC,
                allText = stringResource(R.string.detailedOptions3),
                colorText = colorTextC,
                onButtonClick = {
                    allButton1 = false
                    allButton2 = false
                    allButton3 = true
                }

            )

            Spacer(modifier = Modifier.padding(9.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))

        when {
            allButton1 -> {
                DetailsCard(
                    imageDetail = painterResource(R.drawable.detail_a_1)
                )
                colorA = colorFocused
                colorB = colorUnfocused
                colorC = colorUnfocused

                colorTextA = colorUnfocused
                colorTextB = colorFocused
                colorTextC = colorFocused

            }

            allButton2 -> {
                DetailsCard(
                    imageDetail = painterResource(R.drawable.detail_b_1)
                )
                colorA = colorUnfocused
                colorB = colorFocused
                colorC = colorUnfocused

                colorTextA = colorFocused
                colorTextB = colorUnfocused
                colorTextC = colorFocused
            }

            allButton3 -> {
                DetailsCard(
                    imageDetail = painterResource(R.drawable.detail_c_1)
                )
                colorA = colorUnfocused
                colorB = colorUnfocused
                colorC = colorFocused

                colorTextA = colorFocused
                colorTextB = colorFocused
                colorTextC = colorUnfocused
            }

            else -> {
                DetailsCard(
                    imageDetail = painterResource(R.drawable.detail_a_1)
                )
                colorA = colorFocused
                colorB = colorUnfocused
                colorC = colorUnfocused

                colorTextA = colorUnfocused
                colorTextB = colorFocused
                colorTextC = colorFocused
            }

        }
    }
}

@Composable
fun DetailsCard(
    imageDetail: Painter
){
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondaryContainer),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)

    ) {
        Image(
            painter = imageDetail,
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .padding(8.dp)
                .offset(y = (-40).dp)
        )
    }
}


@Composable
fun DetailsImage(
    navController: NavController,
    tourImage : Int,
    tourStar : Int,
    tourRating : Int,
    tourAmount : Int,
    tourPrice : String,
    route: String
){
    val color =
        if (isSystemInDarkTheme()){
            0xFFB6C4B6
        }else{
            0xFF000000
        }

    Column {
        Box {
            Image(
                painter = painterResource(id = tourImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(20.dp)
            ){
                Button(
                    onClick = { navController.navigate(route) },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .alpha(0.3f)
                ) {

                }
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

        }
        Spacer(modifier = Modifier.height(1.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Divider(
                thickness = 5.dp,
                color = Color(color),
                modifier = Modifier
                    .width(210.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.padding(9.dp))

            Box  (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(170.dp)
                    .height(40.dp)
                    .background(color = MaterialTheme.colorScheme.onTertiary)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = tourStar) ,
                        contentDescription = null,
                        modifier = Modifier
                            .size(65.dp)
                            .offset(y = (3).dp)
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = stringResource(id = tourRating),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onPrimaryContainer

                    )
                    Spacer(modifier = Modifier.padding(1.dp))
                    Text(
                        text = stringResource(id = tourAmount),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }

        Row (verticalAlignment = Alignment.CenterVertically){
            Text(
                text = stringResource(R.string.rp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onErrorContainer,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .offset(y = ((-8).dp))
            )

            Text(
                text = tourPrice,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onErrorContainer,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .offset(y = ((-8).dp))
            )
        }

    }
}

//Don't do Anything
@Composable
fun AllButton (
    allText : String,
    colorText : Color,
    onButtonClick : () -> Unit,
    allColor : Color
)
{
    val color =
        if (isSystemInDarkTheme()){
            Color(0xFF365B36)
        }else{
            MaterialTheme.colorScheme.onTertiary
        }
    Box (contentAlignment = Alignment.Center){
        Button(
            onClick =  onButtonClick,
            modifier = Modifier
                .height(40.dp)
                .width(120.dp),
            colors = ButtonDefaults.buttonColors(allColor),
            border = BorderStroke(2.dp , color = color)

        ) {

        }
        Text (
            text = allText,
            fontSize = 17.sp,
            color = colorText
        )
    }



}
//Don't do Anything
@Composable
fun BottomBar2 (
    navController: NavController,
    nextLabel: String,
    navigate: Boolean,
    route: String
){
    val noNavigate by remember { mutableStateOf(false) }


    BottomAppBar (
        containerColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .shadow(4.dp)
    ){

        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
            ) {
            Button(
                onClick = {
                    if (navigate == noNavigate){
                        navController.navigate(toLogin)
                    }else{
                        navController.navigate(route)
                    }
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier
                    .width(300.dp)
            ) {
                Text(
                    text = nextLabel,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 20.sp
                    )
            }
        }

    }
}
