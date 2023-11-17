package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun DisplayImageWithText(modifier: Modifier = Modifier) {

    var step by remember {
        mutableStateOf(1)
    }

    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val contentDescription = when (step) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.lemon_glass_content_description
        else -> R.string.empty_glass_content_description
    }

    val instructionResource = when (step) {
        1 -> R.string.step_one_text
        2 -> R.string.step_two_text
        3 -> R.string.step_three_text
        else -> R.string.step_four_text
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lemonade",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(249, 228, 76))
                .wrapContentSize(Alignment.Center)
        )
        Spacer(modifier = Modifier.height(180.dp))
        Button(
            onClick = {
                step = if (step == 4) 1 else step+1
            },
            shape = RoundedCornerShape(50.dp),
            contentPadding = PaddingValues(
                top = 40.dp,
                bottom = 40.dp,
                start = 50.dp,
                end= 50.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(195,236,210)
            )
        ) {
            Image(
                painter = painterResource(
                    id = imageResource
                ),
                contentDescription = stringResource(
                    id = contentDescription
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = instructionResource),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeApp() {
    LemonadeAppTheme {
        DisplayImageWithText(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}