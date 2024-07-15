package com.example.nawasena_company.registeredNo

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.scrapFun.BottomBar
import com.example.nawasena_company.scrapFun.TopBar
import com.example.nawasena_company.scrapFun.toMainUnregistered
import com.example.nawasena_company.scrapFun.toResultUnregistered

@Composable
fun MainUnregistered(
    navController: NavController,
    nominalInput: String,
    personInput: String,
    nominalValueChanged: (String) -> Unit,
    personValueChanged: (String) -> Unit
){
    Scaffold (
        topBar = { TopBar(navController = navController, notRegister = true) },
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
            item {
                Spacer(modifier = Modifier.height(40.dp))

                AppSearch(
                    navController = navController,
                    nominalInput = nominalInput,
                    personInput = personInput,
                    nominalValueChanged = nominalValueChanged,
                    personValueChanged = personValueChanged,
                    route = toResultUnregistered
                )
            }
        }
    }
}

@Composable
fun AppSearch(
    navController: NavController,
    nominalInput: String,
    personInput: String,
    nominalValueChanged: (String) -> Unit,
    personValueChanged: (String) -> Unit,
    route: String
){
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    ){

        Card (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary
            )
        ) {
            Box (
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            ){
                SearchField(
                    label = R.string.nominal,
                    fieldTitle = R.string.fieldTitle1,
                    value = nominalInput,
                    onValueChanged = nominalValueChanged,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )
            }

        }

        Card (

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onTertiary
            )

        ) {
            Box (
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            ) {
                SearchField(
                    label = R.string.personal,
                    fieldTitle = R.string.fieldTitle2,
                    value = personInput,
                    onValueChanged = personValueChanged,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )
            }


        }

        Spacer(modifier = Modifier.height(40.dp))

        Box (
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    navController.navigate(route)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.search),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun SearchField(
    @StringRes label: Int,
    @StringRes fieldTitle: Int,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
) {
    val textWipe = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(fieldTitle),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.tertiaryContainer
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder = {
                Text(
                    text = stringResource(label),
                    style = textWipe,
                    color = MaterialTheme.colorScheme.inversePrimary

                )

            },
            modifier = Modifier
                .width(265.dp),
            keyboardOptions = keyboardOptions,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.inverseSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.inverseSurface,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.onSurfaceVariant,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),

        )
    }

}

