package com.example.productivitytimer.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.productivitytimer.ui.theme.ProductivityTimerTheme


@Composable
fun CreateTimerPage(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CreateProductivityTimerText()
        TaskCompletingInput()
        LocationInput()
        SubmitButton{ navHostController.navigate("TimerPage") }
    }
}



@Composable
fun CreateProductivityTimerText(){
    Text(
        modifier = Modifier.padding(10.dp),
        text = "Create Productivity Timer",
        textAlign = TextAlign.Center,
        fontSize = 50.sp,
        lineHeight = 60.sp,
        fontWeight = FontWeight.ExtraBold,
    )
}

@Composable
fun TaskCompletingInput() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {text = it},
        label = { Text("Task Completing") }
    )
}

@Composable
fun LocationInput() {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.padding(top = 10.dp),
        value = text,
        onValueChange = {text = it},
        label = { Text("Location") }
    )
}

@Composable
fun SubmitButton(navigate: () -> Unit) {
    Button(
        onClick = navigate,
        Modifier.padding(top = 20.dp),

        colors = ButtonDefaults.buttonColors(Color.Black),
        shape = RectangleShape,
    ) {
        Text(text = "Start Productive Work",
            Modifier.padding(10.dp),
            fontSize = 16.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun CreateTimerPagePreview() {
    ProductivityTimerTheme {
        CreateTimerPage(navHostController = rememberNavController())
    }
}