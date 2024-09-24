package com.example.softwareengineeringproject.screens.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.softwareengineeringproject.R
import com.example.softwareengineeringproject.Screen
import com.example.softwareengineeringproject.ui.theme.CustomColorsPalette
import com.example.softwareengineeringproject.ui.theme.Roboto

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Dashboard(navController: NavController){
    Scaffold(
        modifier = Modifier.background(colorResource(R.color.DarkerNero)),
        topBar = {
            //title, navigationIcon, actions, and other parameters in Scaffold has their own default position
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .background(color = colorResource(R.color.DarkerNero))
                ,
                title = {
                    Text(
                        text = "Nutritrack",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = (-0.2).sp,
                            fontFamily = Roboto
                        ),
                        color = colorResource(R.color.white)
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.padding(start = 12.dp),
                        onClick = {
                        navController.navigate(Screen.Profile.route)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.profile_icon),
                            contentDescription = "profile_icon",
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }
                },
                actions = {
                    IconButton(
                        modifier = Modifier.padding(end = 12.dp),
                        onClick = {
                        navController.navigate((Screen.Notification.route))
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification_icon),
                            contentDescription = "notification_icon",
                            modifier = Modifier.size(48.dp),
                            tint = colorResource(id = R.color.white)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.DarkerNero)
                )
            )
        },
        bottomBar = {

        }
    ){ innerPadding ->
        val customPadding = PaddingValues(
            //calculates the padding
            start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
            top = innerPadding.calculateTopPadding(),
            end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
            bottom = innerPadding.calculateBottomPadding()
        )
        Column(
            modifier = Modifier
                .padding(customPadding)
                .background(color = colorResource(R.color.DarkerNero))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FirstCard()
            SecondCard()
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FirstCard(){
    Row(
        modifier = Modifier
            .height(height = 212.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
    ){
        val pagerState = rememberPagerState(
            pageCount = {
                3
            }
        )
        val firstCardPageContent = remember { mutableStateOf(FirstCardPageContent(
            //to be replaced with the data from the database
            caloriesToday = 0f,
            totalCalorieGoal = 600f,
            carbsToday = 0f,
            proteinToday = 0f,
            fatToday = 0f,
            caloriesGainedToday = 400f,

        )) }
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
        ){
            HorizontalPager(
                state = pagerState,
                // spaceRemaining = (max width) - (pagerSize)/2
                // end = start + pageSpacing - spaceRemaining
                // for more accurate spacing
                contentPadding = PaddingValues(start = 23.dp, end = 23.dp),
                pageSpacing = 10.dp,
                pageSize = PageSize.Fixed(365.dp)
            ) {
                Card(
                    colors = CardDefaults.cardColors(colorResource(R.color.Nero)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth(),
                ) {
                    when(it) {
                        0 -> FirstCardFirstPage(firstCardPageContent)
                        1 -> FirstCardSecondPage(firstCardPageContent)
                        2 -> FirstCardThirdPage(firstCardPageContent)
                    }
                }
            }
            Row(
                Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(3) { iteration ->
                    val color = if (pagerState.currentPage % 3 == iteration) CustomColorsPalette.dotIndicatorCurrent else CustomColorsPalette.dotIndicatorNotCurrent
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(12.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun FirstCardFirstPage (firstCardPageContent: MutableState<FirstCardPageContent>){
    Column(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp, start = 20.dp, end = 20.dp)
    ){
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontFamily = Roboto, fontSize = 21.sp)){
                    append("Macros ")
                }
                withStyle(style = SpanStyle(color = Color.White, fontFamily = Roboto, fontWeight = FontWeight.Light, fontSize = 21.sp)){
                    append("today")
                }
            }
        )
    }
    Row(
        modifier = Modifier
            .offset(x = 20.dp)
    ){
        firstCardPageContent.value.CaloriesDonutGraph()
    }
}
//firstCardPageContent must contain the StateFlow objects that is coming from the database
@Composable
fun FirstCardSecondPage(firstCardPageContent: MutableState<FirstCardPageContent>) {
    Column(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp, start = 20.dp, end = 20.dp)
    ){
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontFamily = Roboto, fontSize = 21.sp)){
                    append("Micros ")
                }
                withStyle(style = SpanStyle(color = Color.White, fontFamily = Roboto, fontWeight = FontWeight.Light, fontSize = 21.sp)){
                    append("today")
                }
            }
        )
    }
}
@Composable
fun FirstCardThirdPage(firstCardPageContent: MutableState<FirstCardPageContent>) {
    Column(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp, start = 20.dp, end = 20.dp)
    ){
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontFamily = Roboto, fontSize = 21.sp)){
                    append("Macros ")
                }
                withStyle(style = SpanStyle(color = Color.White, fontFamily = Roboto, fontWeight = FontWeight.Light, fontSize = 21.sp)){
                    append("week")
                }
            }
        )
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SecondCard(){
    Box(modifier = Modifier.size(width = 371.dp, height = 200.dp)){
        val pagerState = rememberPagerState(pageCount = {
            3
        })
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
        ){
            Card(
                colors = CardDefaults.cardColors(colorResource(R.color.Nero)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth(),
            ) {

            }
        }
    }
}