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
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50.dp),
            contentPadding = PaddingValues(
                top = 40.dp,
                bottom = 40.dp,
                start = 50.dp,
                end= 50.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(195,236,210)
            ),
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.lemon_tree
                ),
                contentDescription = stringResource(
                    id = R.string.lemon_tree_content_description
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.step_one_text),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeAppTheme {
        DisplayImageWithText(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}