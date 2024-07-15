package com.example.nawasena_company.scrapFun

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavController, notRegister: Boolean
){

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp)
    ) {
        CenterAlignedTopAppBar(
            title = {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(40.dp),

                    )
                    Text(
                        text = stringResource(R.string.title),
                        modifier = Modifier.padding(8.dp),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondary
                    )

                    if (notRegister){
                        Spacer(modifier = Modifier.weight(1f))
                        ToLogin(navController = navController)
                    }



                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ),

            )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCustom2(
    navController: NavController,
    route: String,
    onButtonClick: () -> Unit
    ) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp)
    ) {
        TopAppBar(
            title = {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate(route)
                            }
                    )
                    Spacer(modifier = Modifier.padding(end = 30.dp))
                    Button(
                        onClick = onButtonClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 24.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSecondaryContainer),
                    ) {
                        Text(
                            text = stringResource(R.string.search),
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }

}

@Composable
fun ToLogin(navController: NavController){
    var register by remember { mutableStateOf(false) }

    Box (contentAlignment = Alignment.Center){
        Button(
            onClick = {
                navController.navigate("LoginPage")
                register = true
            },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondaryContainer),
            modifier = Modifier
                .padding(8.dp)
                .width(70.dp),
            shape = RoundedCornerShape(15.dp)
        ) {

        }
        Text(
            text = stringResource(R.string.login),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 16.sp,
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCustom(
    navController: NavController,
    title: String,
    route: String,
    ) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp)
    ) {
        TopAppBar(
            title = {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate(route)
                            }
                    )

                    Spacer(modifier = Modifier.padding(end = 30.dp))

                    Text(
                        text = title,
                        modifier = Modifier.padding(0.dp),
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onSecondary
                    )

                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ),


            )
    }

}



@Composable
fun BottomBar(
    navController: NavController,
    buttonColor1: Color,
    buttonColor2: Color,
    buttonColor3: Color,
    mainChoice: String,
    historyChoice: String,
    profileChoice: String,
    navigate: Boolean

){
    val darkTheme = isSystemInDarkTheme()

    Box (
       modifier = Modifier.shadow(elevation = 20.dp)
    ){
        BottomAppBar (
            containerColor = MaterialTheme.colorScheme.onPrimary
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                ) {

                BottomButton(
                    navController = navController,
                    buttonColor = buttonColor1,
                    image =
                       if (darkTheme){
                           painterResource(R.drawable.history_dark)
                       }else{
                           painterResource(R.drawable.history)
                       },
                    route = historyChoice,
                    navigate = navigate
                )


                Spacer(modifier = Modifier.weight(1f))

                BottomButton(
                    navController = navController,
                    buttonColor = buttonColor2,
                    image =
                        if (darkTheme){
                            painterResource(R.drawable.home_dark)
                        }else{
                            painterResource(R.drawable.home)
                        },
                    route = mainChoice,
                    navigate = navigate
                )

                Spacer(modifier = Modifier.weight(1f))

                BottomButton(
                    navController = navController,
                    buttonColor = buttonColor3,
                    image =
                        if (darkTheme){
                            painterResource(R.drawable.profile_dark)
                        }else{
                            painterResource(R.drawable.profile)
                        },
                    route = profileChoice,
                    navigate = navigate
                )
            }
        }
    }

}

@Composable
fun BottomButton(
    navController: NavController,
    buttonColor: Color,
    image: Painter,
    route: String,
    navigate: Boolean
){
    val noNavigate by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Button(
        onClick = {
            if (navigate == noNavigate){
                Toast.makeText (context, R.string.notif, Toast.LENGTH_SHORT).show()
            }else{
                navController.navigate(route)
            }


        },
        colors = ButtonDefaults.buttonColors( containerColor = buttonColor ),
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)

    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier =  Modifier.size(40.dp)
        )
    }
}
