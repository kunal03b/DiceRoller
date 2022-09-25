package com.gdscmmdu.diceroller

import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gdscmmdu.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceAndButton()
                DiceAndButton2()

            }
        }
    }
}

@Composable
fun DiceAndButton() {
    var result by remember { mutableStateOf(1)}

    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {

        Image(painter = painterResource(imageResource), contentDescription = result.toString())

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            result = (1..6).random()

        }) {
            Text(stringResource(R.string.rollButtonText))
        }
    }
}

@Composable
fun DiceAndButton2() {
    var result1 by remember { mutableStateOf(1)}

    val imageResource = when(result1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),horizontalAlignment = Alignment.CenterHorizontally) {
        Button(modifier = Modifier.rotate(180.0F).padding(vertical = 20.dp),onClick = {
            result1 = (1..6).random()

        }) {
            Text(stringResource(R.string.rollButtonText))
        }

        Image(painter = painterResource(imageResource), contentDescription = result1.toString(), modifier = Modifier.rotate(180.0F))

        Spacer(modifier = Modifier.height(15.dp))


    }
}
