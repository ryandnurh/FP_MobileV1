package com.example.nawasena_company.registeredNo

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.toMainUnregistered
import com.example.nawasena_company.scrapFun.toOpening2

@Composable
fun Opening1(navController: NavController) {
    val darkTheme = isSystemInDarkTheme()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)


    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .offset(x = (20).dp)
            )
            Spacer(modifier = Modifier.padding(end = 35.dp))
            Text(
                text = stringResource(R.string.titleOpening1),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5E995E)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = stringResource(R.string.titleOpening2),
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 28.dp),
            color = MaterialTheme.colorScheme.inverseOnSurface
        )
        Row {
            Text(
                text = stringResource(R.string.titleOpening3),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 28.dp),
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
            Spacer(modifier = Modifier.padding(end = 3.dp))
            Text(
                text = stringResource(R.string.titleOpening4),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF5E995E),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.explainerOpening1),
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 28.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate(toOpening2)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5E995E)
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(start = 28.dp)


        ) {
            Text(
                text = stringResource(R.string.buttonOpening),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Box (
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Image(
                painter =
                if (darkTheme){
                    painterResource(R.drawable.bumi_dark)
                }else{
                    painterResource(R.drawable.bumi)
                },
                contentDescription = null,
                modifier = Modifier.size(370.dp),
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Composable
fun Opening2(navController: NavController) {
    val darkTheme = isSystemInDarkTheme()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        LazyRow{
            item {
                Image(
                    painter =
                    if (darkTheme){
                        painterResource(R.drawable.vektor_dark)
                    }else {
                        painterResource(R.drawable.vektor)
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                )
            }
            item {
                Image(
                    painter =
                    if (darkTheme){
                        painterResource(R.drawable.opening_gelaps)
                    }else {
                        painterResource(R.drawable.vektor2)
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                )
            }
        }

        Text(
            text = stringResource(R.string.explainerOpening2),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.explainerOpening3),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .clip(RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSecondary),

            ) {

            }
            Spacer(modifier = Modifier.padding(end = 9.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(10.dp)
                    .width(15.dp)
                    .clip(RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer),

            ) {

            }
        }

        Spacer(modifier = Modifier.height(200.dp))
        Box(
            contentAlignment = Alignment.Center
        ){

            Button(
                onClick = {
                    navController.navigate(toMainUnregistered)
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(RoundedCornerShape(50.dp)),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
            ) {
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .size(30.dp)
            )
        }

    }
}