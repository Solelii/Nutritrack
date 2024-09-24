package com.example.softwareengineeringproject.screens.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.softwareengineeringproject.ui.theme.CustomColorsPalette
import com.example.softwareengineeringproject.ui.theme.Inter

data class FirstCardPageContent (
    val caloriesToday: Float, //to be replaced with the data from the database
    val totalCalorieGoal: Float, //to be replaced with the data from the database
    val fatToday: Float, //to be replaced with the data from the database
    val proteinToday: Float, //to be replaced with the data from the database
    val carbsToday: Float, //to be replaced with the data from the database
    val filledStrokeWidthCalories: Float = 25f,
    val unfilledStrokeWidthCalories: Float = 20f,
    val caloriesGainedToday: Float, //to be replaced with the data from the database
    val strokeWidthFatProteinCarbohydrates: Float = 17.5f,
    val vitamins: Map<String, Float> = mapOf( //to be replaced with the data from the database
        "Vitamin A" to 0f,
        "Vitamin B12" to 0f,
        "Vitamin C" to 0f
    ),
    val weeklyMacros: Map<String, Float> = mapOf( //to be replaced with the data from the database
        "M" to 0f,
        "Tu" to 0f,
        "W" to 0f,
        "Th" to 0f,
        "F" to 0f,
        "Sa" to 0f,
        "Su" to 0f
    )
){
    @Composable
    fun CaloriesDonutGraph(
        color: Color = CustomColorsPalette.LightOrange,
        modifier: Modifier = Modifier
            .size(75.dp),
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val startAngle = -90f
                //caloriesLeft to percentage to degree
                val sweepAngle = caloriesGainedToday/totalCalorieGoal * 360
                // unfilled arc
                drawArc(
                    color = CustomColorsPalette.hover,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = unfilledStrokeWidthCalories)
                )
                // filled arc
                drawArc(
                    color = color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = filledStrokeWidthCalories, cap = StrokeCap.Round)
                )
            }
            Column (
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                Text(
                    //calorie left for today
                    text = String.format("%.${0}f", totalCalorieGoal - caloriesGainedToday),
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Text(
                    text = """Calories
                     |left""".trimMargin(),
                    fontSize = 10.sp,
                    fontFamily = Inter,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 12.sp
                )
            }
        }
    }

    @Composable
    fun FatProteinCarbBarGraph(
        modifier: Modifier
    ){
        Canvas(modifier = modifier) {
            val barWidth = 225.dp.toPx()
            val barHeight = 5.dp.toPx()
            val textToBarSpacing = 13.5.dp.toPx()
            val textBaseline = 16.5.dp.toPx()

//            //error because forEachIndexed is not a function of map
//            vitamins.forEachIndexed { index, (label, value) ->
//                val textXCoordinate = if (index == 0){
//                    //starting x-coordinate of the horizontal bar chart
//                    textToBarSpacing
//                }else{
//                    index * (barHeight + textToBarSpacing) + textToBarSpacing
//                }
//                //maxValue should be replaced with the total fat/protein/carbohydrate per day
//                val barLength = (value / maxValue) * barWidth
//
//                drawContext.canvas.nativeCanvas.drawText(
//                    label,
//                    //to be replaced with the actual x-coordinate of the content
//                    0f,
//                    //get the x-coordinate of the horizontal bar graph,
//                    //remove the textToBarSpacing from it, then add the text's baseline
//                    textXCoordinate - textToBarSpacing + textBaseline,
//                    Paint().apply {
//                        color = android.graphics.Color.BLACK
//                        textSize = 10f
//                    }
//                )

//                drawRoundRect(
//                    color = Color.Gray,
//                    topLeft = Offset(x = 0f, y = textXCoordinate),
//                    size = Size(width = barWidth, height = barHeight),
//                    cornerRadius = CornerRadius(10.dp.toPx())
//                )
//
//                drawRoundRect(
//                    color = Color.Blue,
//                    topLeft = Offset(x = 0f, y = textXCoordinate),
//                    size = Size(width = barLength, height = barHeight),
//                    cornerRadius = CornerRadius(10.dp.toPx())
//                )

//            }
        }
    }
}