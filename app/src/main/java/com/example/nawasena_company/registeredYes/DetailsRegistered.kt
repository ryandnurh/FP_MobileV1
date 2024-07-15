package com.example.nawasena_company.registeredYes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.registeredNo.BottomBar2
import com.example.nawasena_company.registeredNo.DetailsImage
import com.example.nawasena_company.registeredNo.DetailsLayout
import com.example.nawasena_company.scrapFun.toPayment1
import com.example.nawasena_company.scrapFun.toResultRegistered


@Composable
fun DetailsRegistered(
    navController: NavController,
    title : String,
    image : String,
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


    DetailsYesRegister(
        navController = navController,
        tourName = tourName!!,
        tourImage = tourImage!!,
        tourStar = tourStar!!,
        tourRating = tourRating!!,
        tourAmount = tourAmount!!,
        tourPrice = price

    )
}

@Composable
fun DetailsYesRegister(
    navController: NavController,
    tourName : Int,
    tourImage : Int,
    tourStar : Int,
    tourRating : Int,
    tourAmount : Int,
    tourPrice : String
){
    Scaffold (
        bottomBar = {
            BottomBar2(
                navController = navController,
                nextLabel = stringResource(R.string.orderNow),
                navigate = true,
                route = "$toPayment1/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice"
            )
        }
    ){ip ->
        Column {
            DetailsImage(
                navController = navController,
                tourImage = tourImage,
                tourStar = tourStar,
                tourRating = tourRating,
                tourAmount = tourAmount,
                tourPrice = tourPrice,
                route = toResultRegistered
            )
            Divider(
                thickness = 10.dp,
                color = MaterialTheme.colorScheme.primaryContainer,
            )
            LazyColumn(contentPadding = ip){
                item {
                    DetailsLayout(tourName)
                }
            }
        }
    }
}