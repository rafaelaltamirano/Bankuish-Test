package com.example.bankuishchallenge.ui.theme.screens.repos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bankuishchallenge.R
import com.example.bankuishchallenge.ui.theme.router.Routers
import com.example.bankuishchallenge.ui.theme.screens.MainModel
import com.example.bankuishchallenge.ui.theme.screens.components.TopBar
import com.example.domain.entities.Repo
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.util.*


@Composable
fun ReposListScreen(
    model: ReposListModel,
    mainModel: MainModel,
    navController: NavController
) {

    Text(text = "Hello Main")

    Scaffold(
        topBar = { TopBar() },
    ) {
        if (model.state.loadingRepos) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                    color = Color.Gray
                )
            }
        } else if (model.state.repos.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 30.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    color = Color.LightGray,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    text = "There aren't repositories to show"
                )
            }
        } else {
            RepoList(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                data = model.state.repos,
                model = model,
                navController =navController
            )
        }
    }
}


@Composable
fun RepoList(
    modifier: Modifier = Modifier,
    data: List<Repo>,
    model: ReposListModel,
    navController: NavController,
) {

    if (data.isEmpty()) return

    Box(modifier) {

        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                SwipeRefresh(
                    state = rememberSwipeRefreshState(model.state.loadingRepos),
                    onRefresh = model::requestRepos,
                    indicator = { state, trigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = trigger,
                            contentColor = Color.Green
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    LazyColumn {
                        itemsIndexed(data) { index, item ->
                            LastRepo(
                                index = index,
                                item = item,
                                onPress = {
                                        model.setSelectedRepo(it)
                                        navController.navigate(Routers.REPO_DETAILS.route)},
                            )
                        }
                    }

                }

            }

        }

    }
}


@Composable
fun LastRepo(
    index: Int,
    item: Repo,
    onPress: ((Repo) -> Unit)?,
) {

    val isPair = index % 2 == 0

    Box(
        Modifier
            .background(if (isPair) Color.LightGray else Color.White)
            .fillMaxWidth()
            .clickable(onClick = { onPress?.invoke(item) })
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1.0f)
                    .padding(end = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text =  buildAnnotatedString {
                        append("Repo name: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(item.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },)
                        }
                    },
                    style = MaterialTheme.typography.caption,
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.gap4)),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text =  buildAnnotatedString {
                        append("Created by: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(item.author.login.uppercase())
                        }
                    },
                    style = MaterialTheme.typography.caption,
                    color = Color.Black,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.gap4)),
                    overflow = TextOverflow.Ellipsis
                )

            }

                Image(
                    painter = painterResource(R.drawable.row),
                    contentDescription = "row",
                    modifier = Modifier
                        .height(25.dp)
                        .padding(dimensionResource(R.dimen.gap1))
                )

        }
    }
}

