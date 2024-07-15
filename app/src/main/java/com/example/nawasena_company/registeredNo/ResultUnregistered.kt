package com.example.nawasena_company.registeredNo


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.data.TourPackage
import com.example.nawasena_company.data.tours
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBarCustom2
import com.example.nawasena_company.scrapFun.toDetailsUnregistered
import com.example.nawasena_company.scrapFun.toMainUnregistered
import com.example.nawasena_company.scrapFun.toResultUnregistered
import java.util.Locale


@Composable
fun ResultUnregistered(
    navController: NavController,
    nominalInput: String, personInput: String,
    nominalValueChanged: (String) -> Unit, personValueChanged: (String) -> Unit

){
    val nominal = nominalInput.toIntOrNull() ?:0
    val person = personInput.toIntOrNull() ?:0
    var searchAgain by remember { mutableStateOf(false) }



    Scaffold (
        topBar = {
            TopBarCustom2(
                navController = navController,
                route = toMainUnregistered,
                onButtonClick = {searchAgain = !searchAgain}
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                buttonColor1 = Color.Transparent,
                buttonColor2 = MaterialTheme.colorScheme.onBackground,
                buttonColor3 = Color.Transparent,
                mainChoice = toMainUnregistered,
                historyChoice = toMainUnregistered,
                profileChoice = toMainUnregistered,
                navigate = false
            )
        }
    ) { ip ->
        LazyColumn(contentPadding = ip){
            if (searchAgain){
                item {
                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = stringResource(R.string.command),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp),
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    )
                    AppSearch(
                        navController = navController,
                        nominalInput = nominalInput ,
                        personInput = personInput,
                        nominalValueChanged = nominalValueChanged,
                        personValueChanged = personValueChanged,
                        route = toResultUnregistered
                    )
                }
            }else{
                item {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = stringResource(R.string.recommend),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp),
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                when{
                    nominal >= 600000 && person <= 5 ->
                        items(tours) {
                            TourLayout(
                                navController = navController,
                                tourPackage = it,
                                route = toDetailsUnregistered
                            )
                        }
                }

            }

        }
    }

}




@Composable
fun TourLayout(
    tourPackage: TourPackage,
    navController: NavController,
    route: String
){
    val tourName = tourPackage.tourName
    val tourImage = tourPackage.tourImage
    val tourStar = tourPackage.tourStar
    val tourRating = tourPackage.tourRating
    val tourAmount = tourPackage.tourAmount

    val tourPrice = String.format(Locale("in","ID"),"%,d", tourPackage.tourPrice)


    Card (
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.onTertiary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { navController.navigate("$route/$tourName/$tourImage/$tourStar/$tourRating/$tourAmount/$tourPrice") }
    ) {
        Row {
            TourImage(image = tourPackage.tourImage)

            TourDetails(
                name = tourPackage.tourName,
                star = tourPackage.tourStar,
                rating = tourPackage.tourRating,
                amount = tourPackage.tourAmount,
                price = tourPrice
            )
        }
    }
}

@Composable
fun TourImage(
    @DrawableRes image: Int
){
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = Modifier
            .size(170.dp)
            .padding(7.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}



@Composable
fun TourDetails(
    @StringRes name: Int,
    @DrawableRes star: Int,
    @StringRes rating: Int,
    @StringRes amount: Int,
    price: String
){
    Column(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(
            text = stringResource(name),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(painter = painterResource(star),
                contentDescription = null,
                modifier = Modifier.offset(y = 3.dp)
            )
            Spacer(modifier = Modifier.padding(end = 5.dp))
            Text(
                text = stringResource(rating),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.padding(end = 5.dp))
            Text(
                text = stringResource(amount),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row (verticalAlignment = Alignment.CenterVertically){

            Text(
                text = stringResource(R.string.rp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = price,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

    }
}





