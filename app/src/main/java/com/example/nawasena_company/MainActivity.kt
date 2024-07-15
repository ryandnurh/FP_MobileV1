package com.example.nawasena_company

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nawasena_company.registeredNo.DetailsUnregistered
import com.example.nawasena_company.registeredNo.LogIn
import com.example.nawasena_company.ui.theme.Nawasena_CompanyTheme
import com.example.nawasena_company.registeredNo.MainUnregistered
import com.example.nawasena_company.registeredNo.Opening1
import com.example.nawasena_company.registeredNo.Opening2
import com.example.nawasena_company.registeredNo.ResultUnregistered
import com.example.nawasena_company.registeredYes.DetailsRegistered
import com.example.nawasena_company.registeredYes.History
import com.example.nawasena_company.registeredYes.MainRegistered
import com.example.nawasena_company.registeredYes.Payment3
import com.example.nawasena_company.registeredYes.PaymentDetails
import com.example.nawasena_company.registeredYes.PaymentMethod
import com.example.nawasena_company.registeredYes.Profile
import com.example.nawasena_company.registeredYes.ResultRegistered
import com.example.nawasena_company.scrapFun.toDetailsRegistered
import com.example.nawasena_company.scrapFun.toDetailsUnregistered
import com.example.nawasena_company.scrapFun.toHistory
import com.example.nawasena_company.scrapFun.toLogin
import com.example.nawasena_company.scrapFun.toMainRegistered
import com.example.nawasena_company.scrapFun.toMainUnregistered
import com.example.nawasena_company.scrapFun.toOpening2
import com.example.nawasena_company.scrapFun.toPayment1

import com.example.nawasena_company.scrapFun.toPayment3
import com.example.nawasena_company.scrapFun.toPaymentMethod
import com.example.nawasena_company.scrapFun.toProfile
import com.example.nawasena_company.scrapFun.toResultRegistered
import com.example.nawasena_company.scrapFun.toResultUnregistered
import com.example.nawasena_company.scrapFun.toSignUp
import com.example.nawasena_company.scrapFun.variables

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nawasena_CompanyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation(){
    val nav = rememberNavController()
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var nominalInput by remember { mutableStateOf("") }
    var personInput by remember { mutableStateOf("") }

    val usernameAdmin = stringResource(R.string.email_admin)
    val passwordAdmin = stringResource(R.string.password_admin)
    val phoneAdmin = stringResource(R.string.phone_admin)


    if (phoneAdmin == stringResource(R.string.phone_admin)){
        phoneNumber = phoneAdmin
    }

    NavHost(
        navController = nav,
        startDestination = "Opening1",
        builder = {
            composable("Opening1"){
                Opening1(nav)
            }
            composable(toOpening2){
                Opening2(nav)
            }
            composable(toLogin){
                LogIn(
                    navController = nav,
                    input1 = email, input1Change = { email = it },
                    input2 = password, input2Change = { password = it },
                    holder1 = stringResource(R.string.emailHolder),
                    holder2 = stringResource(R.string.passHolder),
                    fieldTitle1 = stringResource(R.string.email),
                    fieldTitle2 = stringResource(R.string.password),
                    proceed1 = stringResource(R.string.login),
                    proceed2 = stringResource(R.string.signUp),
                    usernameAdmin = usernameAdmin,
                    passwordAdmin = passwordAdmin,
                    phoneAdmin = phoneAdmin
                )
            }

            composable(toMainUnregistered){
                MainUnregistered(
                    navController = nav,
                    nominalInput = nominalInput,
                    personInput = personInput,
                    nominalValueChanged = { nominalInput = it },
                    personValueChanged = { personInput = it }

                )
            }
            composable(toMainRegistered){
                MainRegistered(
                    navController = nav,
                    nominalInput = nominalInput,
                    personInput = personInput,
                    nominalValueChanged = { nominalInput = it },
                    personValueChanged = { personInput = it }
                )

            }
            composable(toResultUnregistered){
                ResultUnregistered(
                    nominalInput = nominalInput,
                    personInput = personInput,
                    nominalValueChanged = { nominalInput = it },
                    personValueChanged = { personInput = it},
                    navController = nav,
                )
            }
            composable(toResultRegistered){
                ResultRegistered(
                    nominalInput = nominalInput,
                    personInput = personInput,
                    nominalValueChanged = { nominalInput = it },
                    personValueChanged = { personInput = it},
                    navController = nav,
                )
            }
            composable(toDetailsUnregistered + variables){ navBackStack ->
                val tourName = navBackStack.arguments?.getString("tourName")
                val tourImage = navBackStack.arguments?.getString("tourImage")
                val tourStar = navBackStack.arguments?.getString("tourStar")
                val tourRating = navBackStack.arguments?.getString("tourRating")
                val tourAmount = navBackStack.arguments?.getString("tourAmount")
                val tourPrice = navBackStack.arguments?.getString("tourPrice")

                DetailsUnregistered(
                    nav,
                    tourName!!,
                    tourImage!!,
                    tourStar!!,
                    tourRating!!,
                    tourAmount!!,
                    tourPrice!!
                )
            }
            composable(toDetailsRegistered + variables){ navBackStack ->
                val tourName = navBackStack.arguments?.getString("tourName")
                val tourImage = navBackStack.arguments?.getString("tourImage")
                val tourStar = navBackStack.arguments?.getString("tourStar")
                val tourRating = navBackStack.arguments?.getString("tourRating")
                val tourAmount = navBackStack.arguments?.getString("tourAmount")
                val tourPrice = navBackStack.arguments?.getString("tourPrice")

                DetailsRegistered(
                    nav,
                    tourName!!,
                    tourImage!!,
                    tourStar!!,
                    tourRating!!,
                    tourAmount!!,
                    tourPrice!!
                )
            }

            composable(toProfile){
                Profile(
                    navController = nav,
                    email = email,
                    phone = phoneNumber
                )
            }
            composable(toHistory){
                History(nav)
            }
            composable(toPayment1 + variables){navBackStack ->
                val tourName = navBackStack.arguments?.getString("tourName")
                val tourImage = navBackStack.arguments?.getString("tourImage")
                val tourStar = navBackStack.arguments?.getString("tourStar")
                val tourRating = navBackStack.arguments?.getString("tourRating")
                val tourAmount = navBackStack.arguments?.getString("tourAmount")
                val tourPrice = navBackStack.arguments?.getString("tourPrice")

                PaymentDetails(
                    title = tourName!!,
                    image = tourImage!!,
                    star = tourStar!!,
                    rating = tourRating!!,
                    amount = tourAmount!!,
                    tourPrice = tourPrice!!,
                    navController = nav
                )
            }
            composable(toPaymentMethod + variables){navBackStack ->
                val tourName = navBackStack.arguments?.getString("tourName")
                val tourImage = navBackStack.arguments?.getString("tourImage")
                val tourStar = navBackStack.arguments?.getString("tourStar")
                val tourRating = navBackStack.arguments?.getString("tourRating")
                val tourAmount = navBackStack.arguments?.getString("tourAmount")
                val tourPrice = navBackStack.arguments?.getString("tourPrice")

                PaymentMethod(
                    title = tourName!!,
                    image = tourImage!!,
                    star = tourStar!!,
                    rating = tourRating!!,
                    amount = tourAmount!!,
                    price = tourPrice!!,
                    navController = nav
                )
            }
            composable(toPayment3 + variables){navBackStack ->
                val tourName = navBackStack.arguments?.getString("tourName")
                val tourImage = navBackStack.arguments?.getString("tourImage")
                val tourStar = navBackStack.arguments?.getString("tourStar")
                val tourRating = navBackStack.arguments?.getString("tourRating")
                val tourAmount = navBackStack.arguments?.getString("tourAmount")
                val tourPrice = navBackStack.arguments?.getString("tourPrice")

                Payment3(
                    navController = nav,
                    title = tourName!!,
                    image = tourImage!!,
                    star = tourStar!!,
                    rating = tourRating!!,
                    amount = tourAmount!!,
                    tourPrice = tourPrice!!
                )
            }
        }
    )
}



