package com.example.nawasena_company.registeredYes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.data.tours
import com.example.nawasena_company.registeredNo.AppSearch
import com.example.nawasena_company.registeredNo.TourLayout
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBarCustom2
import com.example.nawasena_company.scrapFun.toDetailsRegistered
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toMainRegistered
import com.example.nawasena_company.scrapFun.toProfile
import com.example.nawasena_company.scrapFun.toResultRegistered


@Composable
fun ResultRegistered(
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
                route = toMainRegistered,
                onButtonClick = {searchAgain = !searchAgain}
            )
        },
        bottomBar = {
            BottomBar(
                navController = navController,
                buttonColor1 = Color.Transparent,
                buttonColor2 = MaterialTheme.colorScheme.onPrimaryContainer,
                buttonColor3 = Color.Transparent,
                mainChoice = toMainRegistered,
                historyChoice = toHistory,
                profileChoice = toProfile,
                navigate = true
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
                        route = toResultRegistered
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
                                route = toDetailsRegistered
                            )
                        }
                }

            }

        }
    }

}