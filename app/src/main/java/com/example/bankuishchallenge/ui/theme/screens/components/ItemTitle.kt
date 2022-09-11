package com.example.bankuishchallenge.ui.theme.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun ItemTitle(
    title: String,
    colorTitle: Color,
    subtitle: String,
    colorSubtitle: Color,
    modifier: Modifier = Modifier,
    maxLines: Int? = 2
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            color = colorTitle,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )

        Text(
            text = subtitle,
            color = colorSubtitle,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = maxLines ?: 2,
            textAlign = TextAlign.Center
        )

    }

}
