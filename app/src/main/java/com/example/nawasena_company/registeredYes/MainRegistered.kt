package com.example.nawasena_company.registeredYes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nawasena_company.registeredNo.AppSearch
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBar
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toMainRegistered
import com.example.nawasena_company.scrapFun.toProfile
import com.example.nawasena_company.scrapFun.toResultRegistered

@Composable
fun MainRegistered(
    navController: NavController,
    nominalInput: String, personInput: String,
    nominalValueChanged: (String) -> Unit,
    personValueChanged: (String) -> Unit
){

    Scaffold (
        topBar = { TopBar(navController = navController, notRegister = false) },
        bottomBar = {
            BottomBar(
                navController = navController,
                buttonColor1 = Color.Transparent,
                buttonColor2 = MaterialTheme.colorScheme.onBackground,
                buttonColor3 = Color.Transparent,
                mainChoice = toMainRegistered,
                historyChoice = toHistory,
                profileChoice = toProfile,
                navigate = true
            )
        }
    ) { ip ->
        LazyColumn(contentPadding = ip){
            item {
                Spacer(modifier = Modifier.height(40.dp))

                AppSearch(
                    navController =navController ,
                    nominalInput = nominalInput,
                    personInput = personInput,
                    nominalValueChanged = nominalValueChanged,
                    personValueChanged = personValueChanged,
                    route = toResultRegistered
                )
            }

        }

    }
}