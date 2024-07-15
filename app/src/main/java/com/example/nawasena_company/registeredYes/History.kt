package com.example.nawasena_company.registeredYes

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBarCustom
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toMainRegistered
import com.example.nawasena_company.scrapFun.toProfile

@Composable
fun History(navController: NavController){

    val tourDate = R.string.history_date
    val tourImage = R.drawable.tour_1
    val tourTitle = R.string.Tours1
    val tourPrice = R.string.prices
    val tourRating = R.string.rate

    Scaffold (
        topBar = {
            TopBarCustom(
                navController = navController,
                title = stringResource(R.string.history),
                route = toMainRegistered
            )
        },
        bottomBar = {
            BottomBar(navController = navController,
                buttonColor1 = MaterialTheme.colorScheme.onBackground,
                buttonColor2 = Color.Transparent,
                buttonColor3 = Color.Transparent,
                mainChoice = toMainRegistered,
                historyChoice = toHistory,
                profileChoice = toProfile,
                navigate = true
            )
        }
    ) {ip ->
        LazyColumn(contentPadding = ip){
            item {
                Spacer(modifier = Modifier.height(40.dp))
                HistoryLayout(
                    tourDate,
                    tourImage,
                    tourTitle,
                    tourPrice,
                    tourRating
                )
            }
        }
    }
}


@Composable
fun HistoryLayout(
    date : Int,
    image : Int,
    title : Int,
    price : Int,
    rating :Int
){
    Column {
        HistoryDate(
            date
        )
        Spacer(modifier = Modifier.height(2.dp))
        HistoryCard(image, title, price )
        Spacer(modifier = Modifier.height(4.dp))
        HistoryRating(rating)

    }
}

@Composable
fun HistoryCard(
    image : Int,
    title : Int,
    price : Int
){
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(20.dp))
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(20.dp)
        ),
        colors =
        if (isSystemInDarkTheme()){
            CardDefaults.cardColors(Color(0xFF436A43))
        }else{
            CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondaryContainer)
        }

    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            HistoryImage(image)
            Spacer(modifier = Modifier.padding(end = 8.dp))
            HistoryDetails(title)
        }
        HistoryPrice(price)
    }
}


@Composable
fun HistoryDate(
    @StringRes date : Int
){
    Box (
        modifier = Modifier
            .background(
                if (isSystemInDarkTheme()) {
                    Color(0xFF22422E)
                } else {
                    MaterialTheme.colorScheme.outline
                }

            )
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(date),
            modifier = Modifier.padding(12.dp),
            color = MaterialTheme.colorScheme.onSecondary,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun HistoryImage(
    @DrawableRes image : Int
){
    Image(
        painter = painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .width(130.dp)
            .height(108.dp)
    )
}

@Composable
fun HistoryDetails(
    @StringRes title : Int
){
    Column {
        Text(
            text = stringResource(title),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color =
            if (isSystemInDarkTheme()){
                Color(0xFFFFFFFF)
            }else{
                MaterialTheme.colorScheme.onSecondary
            }

        )
        
        Spacer(modifier = Modifier.height(6.dp))

        Card (
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onTertiary),
            modifier = Modifier.width(200.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ){

                Image(
                    painter = painterResource(R.drawable.five_star),
                    contentDescription = null,
                    modifier = Modifier.offset(y = 4.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(R.string.rating1),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(end= 4.dp))

                Text(
                    text = stringResource(R.string.ratingAmount1),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.inverseOnSurface
                )
            }
        }
    }
}

@Composable
fun HistoryPrice(
    @StringRes price : Int
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        ){
        Text(
            text = stringResource(id = R.string.rp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color =
            if (isSystemInDarkTheme()){
                Color(0xFF86E286)
            }else{
                MaterialTheme.colorScheme.onTertiaryContainer
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(price),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color =
                if (isSystemInDarkTheme()){
                    Color(0xFF86E286)
                }else{
                    MaterialTheme.colorScheme.onTertiaryContainer
                }

        )

        Spacer(modifier = Modifier.weight(1f))

        Divider(
            thickness = 8.dp,
            color = MaterialTheme.colorScheme.inverseOnSurface,
            modifier = Modifier
                .width(150.dp)
                .clip(RoundedCornerShape(24.dp))
        )
    }

}

@Composable
fun HistoryRating(
    @StringRes rating : Int
){

    val develop = true
    val context = LocalContext.current

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        ){
        Text(
            text = stringResource(R.string.rate_confirmation),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.weight(1f))

        Card (
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onTertiary),
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                    if (develop) {
                        Toast
                            .makeText(context, R.string.develop, Toast.LENGTH_SHORT)
                            .show()
                    }

                }
        ){
            Text(
                text = stringResource(rating),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color =
                if (isSystemInDarkTheme()){
                    Color(0xFFFFFFFF)
                }else{
                    MaterialTheme.colorScheme.secondaryContainer
                },
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp)
            )

        }
    }
}