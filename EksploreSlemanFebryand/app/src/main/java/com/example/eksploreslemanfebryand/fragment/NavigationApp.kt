package com.example.eksploreslemanfebryand.fragment

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eksploreslemanfebryand.page.DetailPesananScreen

@Composable
fun Navigation(){
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = "HalamanPembayaran",
        builder = {
            composable("HalamanPembayaran") {
                DetailPesananScreen()
            }
        }
    )
}