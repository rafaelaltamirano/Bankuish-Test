package com.example.bankuishchallenge.ui.theme.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.bankuishchallenge.R

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.bankuish_logo),
                contentDescription = "logo",
                modifier = Modifier.fillMaxSize()
            )
        },
        backgroundColor = Color.White
    )
}
