package com.example.eksploreslemanfebryand.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.eksploreslemanfebryand.R
import com.example.eksploreslemanfebryand.fragment.TopBar

@Composable
fun DetailPesananScreen(){
    Scaffold (
        topBar = { TopBar() }
    ){ip ->
        LazyColumn(contentPadding = ip){
            item{ DetailPaket() }
        }
    }
}

@Composable
fun DetailPaket(){
    Card (
        modifier = Modifier
            .padding(8.dp)
            .height(200.dp)
    ){
        Box (
            modifier = Modifier
                .background(
                    color = Color.White
                )
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Image(
                painter = painterResource(id = R.drawable.img_obelix),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Image(
                painter = painterResource(id = R.drawable.img_obelix_gradient),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Column {
                Row{
                    Image(
                        painter = painterResource(id = R.drawable.img_obelix),
                        contentDescription = null,
                        modifier = Modifier
                            .width(91.dp)
                            .height(75.dp)
                    )
                }
            }
        }
    }
}