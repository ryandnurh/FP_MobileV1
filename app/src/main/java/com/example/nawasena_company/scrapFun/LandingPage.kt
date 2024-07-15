package com.example.nawasena_company.scrapFun

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nawasena_company.R
import com.example.nawasena_company.registeredNo.ExploreLogo
import com.example.nawasena_company.registeredNo.LoginField
import com.example.nawasena_company.registeredNo.PasswordField

@Composable
fun LandingPageLayout(
    navController: NavController,
    input1: String, input2: String,
    holder1: String, holder2: String,
    fieldTitle1: String, fieldTitle2: String,
    proceed1: String, proceed2: String,

    usernameAdmin: String, passwordAdmin: String, phoneAdmin: String,
    input1Change: (String) -> Unit, input2Change: (String) -> Unit,
){
    val context = LocalContext.current
    var phone by remember { mutableStateOf("") }

    Column {

        Spacer(modifier = Modifier.height(30.dp))

        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            ExploreLogo()
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box  (
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ){
            Column {
                LoginField(
                    input = input1,
                    inputChange = input1Change,
                    holder = holder1,
                    fieldTitle = fieldTitle1
                )

                Spacer(modifier = Modifier.height(30.dp))

                PasswordField(
                    input = input2,
                    inputChange = input2Change,
                    holder = holder2,
                    fieldTitle = fieldTitle2
                )
            }

        }
        Spacer(modifier = Modifier.height(60.dp))

        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    if (input1 == usernameAdmin && input2 == passwordAdmin){
                        navController.navigate(toMainRegistered)
                        phone = phoneAdmin
                    }else{
                        Toast.makeText(context, R.string.error_input, Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiary),
                modifier = Modifier
                    .width(150.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = proceed1,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.or),
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = proceed2,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.clickable { Toast.makeText (context, R.string.develop, Toast.LENGTH_SHORT).show() }
                )
            }
        }

    }

}