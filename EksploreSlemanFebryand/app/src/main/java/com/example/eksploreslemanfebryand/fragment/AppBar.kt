package com.example.eksploreslemanfebryand.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val shape = RoundedCornerShape(20.dp)
    val backgroundColor = if (isPressed) Color.Blue else Color.White
    val textColor = if (isPressed) Color.Blue else Color.Black
    val borderWidth = if (isPressed) 1.dp else 0.dp
    val borderColor = if (isPressed) Color.White else Color.White
    val clickable = Modifier.clickable(
        interactionSource = interactionSource,
        indication = rememberRipple(true)
    ){ print("uy") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp)
    ){
        TopAppBar(
            title = {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                    ){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape)
                            .border(
                                width = borderWidth,
                                color = borderColor,
                                shape = shape,
                            )
                            .then(clickable),
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Detail Pesanan",
                        fontSize = 20.sp,
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}