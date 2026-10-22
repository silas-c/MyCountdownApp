package com.example.mycountdownapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mycountdownapp.ui.theme.MyCountdownAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCountdownAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Countdown(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Countdown(modifier: Modifier = Modifier) {
    val counterStart = 100
    val scope = rememberCoroutineScope()
    var counter by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = counter.toString(), modifier = modifier, fontSize = 98.sp)
        Button(onClick =
            {
                scope.launch {
                    repeat(counterStart) {
                        counter = (counterStart-it)
                        delay(1000.milliseconds)
                    }
                }.start()
            }) {
            Image(
                painter = painterResource(android.R.drawable.ic_media_play),
                contentDescription = "Start"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCountdownAppTheme {
        Countdown()
    }
}
