package com.example.bankuishchallenge.ui.theme.screens.reposDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankuishchallenge.R
import com.example.bankuishchallenge.ui.theme.screens.MainModel
import com.example.bankuishchallenge.ui.theme.screens.repos.ReposListModel

@Composable
fun ReposDetailsScreen(
    model: ReposListModel,
    mainModel: MainModel,
) {
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Details",
                style = MaterialTheme.typography.h1,
                color = Black,
                fontSize = 25.sp,
                modifier = Modifier.padding(dimensionResource(R.dimen.gap4))
            )

        }
        Divider(
            color = Color.Green,
            thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Row(
            Modifier.weight(1f).padding(dimensionResource(R.dimen.gap4)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {


            Text(
                text = "Author: ${model.state.selectedRepo?.author?.login}",
                color = Black,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
        Divider(
            color = Color.Green,
            thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Row(
            Modifier.weight(1f).padding(dimensionResource(R.dimen.gap4)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "Name: ${model.state.selectedRepo?.name}",
                color = Black,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
        Divider(
            color = Color.Green,
            thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Row(
            Modifier.weight(1f).padding(dimensionResource(R.dimen.gap4)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {


            Text(
                text = "Full Name: ${model.state.selectedRepo?.fullName}",
                color = Black,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
        Divider(
            color = Color.Green,
            thickness = 1.dp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Row(
            Modifier.weight(1f).padding(dimensionResource(R.dimen.gap4)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {


            Text(
                text = "Url: ${model.state.selectedRepo?.url}",
                color = Black,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }

    }
}